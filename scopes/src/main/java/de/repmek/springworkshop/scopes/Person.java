package de.repmek.springworkshop.scopes;

import de.repmek.springworkshop.scopes.tabScope.TabScope;
import org.springframework.stereotype.Component;

@Component
@TabScope
public class Person {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
