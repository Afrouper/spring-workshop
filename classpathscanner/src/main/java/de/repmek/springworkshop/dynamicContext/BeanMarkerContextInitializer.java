package de.repmek.springworkshop.dynamicContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.support.GenericApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class BeanMarkerContextInitializer implements ApplicationContextInitializer<GenericApplicationContext>
{
    private static final Logger LOGGER = LoggerFactory.getLogger(BeanMarkerContextInitializer.class);
    private final List<String> basePackages;

    public BeanMarkerContextInitializer(String basePackage, String ... additionalBasePackages) {
        basePackages = new ArrayList<>();
        Objects.requireNonNull(basePackage, "At least one basePacke to scan must be provided.");
        basePackages.add(basePackage);
        for (String additionalBasePackage : additionalBasePackages) {
            basePackages.add(additionalBasePackage);
        }
    }

    @Override
    public void initialize(GenericApplicationContext applicationContext)
    {
        LOGGER.info("Initializing applicationContext.");
        BeanDefinitionRegistry beanDefinitionRegistry = (BeanDefinitionRegistry) applicationContext.getBeanFactory();

        BeanMarkerClasspathScanner scanner = new BeanMarkerClasspathScanner();
        Set<BeanDefinition> beanDefinitions = scanner.scan(basePackages.toArray(new String[basePackages.size()]));

        for (BeanDefinition beanDefinition : beanDefinitions)
        {
            LOGGER.debug("Register bean definition for class {}", beanDefinition.getBeanClassName());
            beanDefinitionRegistry.registerBeanDefinition(beanDefinition.getBeanClassName(), beanDefinition);
        }
    }
}
