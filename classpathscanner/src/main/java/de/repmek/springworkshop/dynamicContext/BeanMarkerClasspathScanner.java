package de.repmek.springworkshop.dynamicContext;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import static java.util.Arrays.asList;


class BeanMarkerClasspathScanner extends ClassPathScanningCandidateComponentProvider
{
    BeanMarkerClasspathScanner() {
        super(false);
    }

    Set<BeanDefinition> scan(String... basePackages) {
        Set<BeanDefinition> beanDefinitions = new HashSet<>();
        for (String basePackage : basePackages) {
            beanDefinitions.addAll(scanImpl(basePackage));
        }
        return beanDefinitions;
    }

    private Set<BeanDefinition> scanImpl(String basePackage) {
        Set<BeanDefinition> candidates = findCandidateComponents(basePackage);
        for (BeanDefinition candidate : candidates)
        {
            candidate.setScope(BeanDefinition.SCOPE_SINGLETON);
        }
        return candidates;
    }

    @Override
    protected boolean isCandidateComponent(MetadataReader metadataReader) throws IOException
    {
        ClassMetadata classMetadata = metadataReader.getClassMetadata();
        boolean hasInterface = asList(classMetadata.getInterfaceNames()).contains(BeanMarker.class.getName());
        return hasInterface;
    }
}
