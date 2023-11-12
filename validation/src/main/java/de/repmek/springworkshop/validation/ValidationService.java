package de.repmek.springworkshop.validation;

import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.ArrayList;
import java.util.List;

@Service
@Validated
public class ValidationService {

    private List<HostAddress> hosts = new ArrayList<>();

    public void addHost(@Valid HostAddress hostAddress) {
        hosts.add(hostAddress);
    }

    public List<HostAddress> getHosts() {
        return hosts;
    }
}
