package com.anhlam.petrang.Annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.Assert;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class AnnotationBusiness {

    @Bean
    public void handler() throws ClassNotFoundException {
        Class<?> clazz = ClassLoader.getSystemClassLoader()
                .loadClass("com.anhlam.petrang.Annotation.HandlingBusiness");
        HandlingBusiness classAnnotation = clazz.getAnnotation(HandlingBusiness.class);
        if (classAnnotation.value().equals("anhlam")) {
            Method[] methods = clazz.getMethods();
            List<String> annotatedMethods = new ArrayList<>();
            for (Method method : methods) {
                HandlingBusiness annotation = method.getAnnotation(HandlingBusiness.class);
                if (annotation != null) {
                    annotatedMethods.add(annotation.value());
                }
            }
        }
    }
}
