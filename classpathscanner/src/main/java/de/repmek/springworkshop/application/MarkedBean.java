package de.repmek.springworkshop.application;

import de.repmek.springworkshop.dynamicContext.BeanMarker;

public class MarkedBean implements BeanMarker {

    public String sayHello(String name) {
        return "Hello " + name;
    }
}
