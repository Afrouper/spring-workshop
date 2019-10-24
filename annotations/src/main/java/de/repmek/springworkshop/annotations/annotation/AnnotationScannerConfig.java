package de.repmek.springworkshop.annotations.annotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(basePackages = "de.repmek.springworkshop.annotations", includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = CustomAnnotation.class)})
public class AnnotationScannerConfig {
}
