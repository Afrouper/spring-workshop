package de.repmek.springworkshop.validation;

import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ValidationServiceTest {

    @Autowired
    private ValidationService validationService;

    @Test
    public void addValidHost() {
        HostAddress hostAddress = createValidHostAddress();
        validationService.addHost(hostAddress);

        List<HostAddress> hosts = validationService.getHosts();
        assertEquals(1, hosts.size());
    }

    @Test()
    public void addHost_invalidName() {
        HostAddress hostAddress = createValidHostAddress();
        hostAddress.setHostname("all planets of the milkyway");
        assertThrows(ConstraintViolationException.class, () -> validationService.addHost(hostAddress));
    }

    @Test()
    public void addHost_invalidIP() {
        HostAddress hostAddress = createValidHostAddress();
        hostAddress.setIpAddress("192.168.256.0");
        assertThrows(ConstraintViolationException.class, () -> validationService.addHost(hostAddress));

        hostAddress.setIpAddress("Foo");
        assertThrows(ConstraintViolationException.class, () -> validationService.addHost(hostAddress));
    }

    @Test()
    public void addHost_invalidMaxClients() {
        HostAddress hostAddress = createValidHostAddress();
        hostAddress.setMaxClients(0);
        assertThrows(ConstraintViolationException.class, () -> validationService.addHost(hostAddress));

        hostAddress.setMaxClients(1000);
        assertThrows(ConstraintViolationException.class, () -> validationService.addHost(hostAddress));
    }

    private HostAddress createValidHostAddress() {
        HostAddress hostAddress = new HostAddress();
        hostAddress.setHostname("merkur");
        hostAddress.setIpAddress("192.168.42.2");
        hostAddress.setMaxClients(50);
        return hostAddress;
    }
}
