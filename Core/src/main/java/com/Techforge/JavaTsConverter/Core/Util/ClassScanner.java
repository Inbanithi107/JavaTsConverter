package com.Techforge.JavaTsConverter.Core.Util;

import com.Techforge.JavaTsConverter.Annotations.ScanPackage;
import com.Techforge.JavaTsConverter.Core.JavaTypescriptGenerator;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClassScanner {

    private JavaTypescriptGenerator javaTypescriptGenerator;

    private ScanPackage scanPackage;

    @Autowired
    public ClassScanner(JavaTypescriptGenerator javaTypescriptGenerator){
        this.javaTypescriptGenerator = javaTypescriptGenerator;
        this.scanPackage = new ScanPackage();
    }

    public Class<?>[] getAnnotatedClasses(){
        System.out.println("Base Package : "+ javaTypescriptGenerator.getBasePackage());
        scanPackage.setBasePackage(javaTypescriptGenerator.getBasePackage());
        return scanPackage.getClassForDto();
    }

    public ClassScanner(){

    }

    public void details(){
        System.out.println("Base Package : "+javaTypescriptGenerator.getBasePackage());
    }

    @PostConstruct
    public void log(){
        System.out.println("dependency injection");
    }

}
