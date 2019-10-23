package de.repmek.springworkshop.classpathscanner;

import de.repmek.springworkshop.application.MarkedBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SampleApplication {

    @Autowired
    private MarkedBean markedBean;

    public String sayHello(String name) {
        return markedBean.sayHello(name);
    }
}
