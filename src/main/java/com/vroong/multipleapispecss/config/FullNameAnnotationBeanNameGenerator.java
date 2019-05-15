package com.vroong.multipleapispecss.config;

import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.context.annotation.AnnotationBeanNameGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Set;

public class FullNameAnnotationBeanNameGenerator implements BeanNameGenerator {

    private final AnnotationBeanNameGenerator defaultGenerator = new AnnotationBeanNameGenerator();

    @Override
    public String generateBeanName(BeanDefinition definition, BeanDefinitionRegistry registry) {
        if (checkIfController(definition)) {
            return generateFullBeanName((AnnotatedBeanDefinition) definition);
        } else{
            return this.defaultGenerator.generateBeanName(definition, registry);
        }
    }

    private boolean checkIfController(BeanDefinition definition) {
        return getAnnotationTypes(definition).stream()
            .anyMatch(x -> Controller.class.getName().equals(x) || RestController.class.getName().equals(x));
    }

    private Set<String> getAnnotationTypes(BeanDefinition definition) {
        if (definition instanceof AnnotatedBeanDefinition)
            return ((AnnotatedBeanDefinition) definition).getMetadata().getAnnotationTypes();
        else
            return Collections.emptySet();
    }

    private String generateFullBeanName(final AnnotatedBeanDefinition definition) {
        return definition.getMetadata().getClassName();
    }
}
