package de.repmek.springworkshop.scopes.tabScope;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Custom scope to store spring-beans in for each browser-Tab.
 *
 * <b>Note:</b> the client/browser must send the HTTP-Header "X-Scope-tabId" to get access to the correct beans.
 */
@Qualifier
@Scope("tab")
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface TabScope {
}
