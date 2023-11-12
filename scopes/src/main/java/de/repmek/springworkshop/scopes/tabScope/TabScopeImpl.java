package de.repmek.springworkshop.scopes.tabScope;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.lang.Nullable;
import org.springframework.web.context.request.SessionScope;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class TabScopeImpl extends SessionScope {

    private static final String HEADER_NAME = "X-Scope-tabId";

    private final ObjectFactory<HttpServletRequest> request;

    public TabScopeImpl(ObjectFactory<HttpServletRequest> request) {
        this.request = request;
    }

    private String getTabId() {
        String header = request.getObject().getHeader(HEADER_NAME);
        if(header != null) {
            //Avoid illegal characters
            return "-" + URLEncoder.encode(header, StandardCharsets.UTF_8);
        }
        else {
            return "-unknown";
        }
    }

    @Override
    public String getConversationId() {
        return super.getConversationId() + getTabId();
    }

    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        String instanceName = name + getTabId();
        return super.get(instanceName, objectFactory);
    }

    @Override
    @Nullable
    public Object remove(String name) {
        String instanceName = name + getTabId();
        return super.remove(instanceName);
    }

    @Override
    public void registerDestructionCallback(String name, Runnable callback) {
        String instanceName = name + getTabId();
        super.registerDestructionCallback(instanceName, callback);
    }

    @Override
    @Nullable
    public Object resolveContextualObject(String key) {
        String instanceName = key + getTabId();
        return super.resolveContextualObject(instanceName);
    }
}
