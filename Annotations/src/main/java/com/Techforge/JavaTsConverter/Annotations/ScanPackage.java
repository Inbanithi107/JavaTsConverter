package com.Techforge.JavaTsConverter.Annotations;

import org.reflections.Reflections;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Set;

public class ScanPackage {

    private String basePackage;

    public ScanPackage(String basePackage){
        this.basePackage = basePackage;
    }

    public ScanPackage(){

    }

    public void setBasePackage(String basePackage){
        this.basePackage = basePackage;
    }

    public Class<?>[] getClassForDto(){

        Reflections reflections = new Reflections(basePackage);
        Set<Class<?>> classes = reflections.getTypesAnnotatedWith(SharedObject.class);
        return classes.toArray(new Class<?>[0]);
    }

}
