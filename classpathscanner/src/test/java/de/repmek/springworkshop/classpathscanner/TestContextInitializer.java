package de.repmek.springworkshop.classpathscanner;

import de.repmek.springworkshop.dynamicContext.BeanMarkerContextInitializer;

public class TestContextInitializer extends BeanMarkerContextInitializer {

    public TestContextInitializer() {
        super("de.repmek.springworkshop.application");
    }
}
