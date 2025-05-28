package com.Techforge.JavaTsConverter.Core;

import com.Techforge.JavaTsConverter.Core.Util.DtoGenerator;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Runner {

    public static void run(){

        try(AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.Techforge.JavaTsConverter")){

            DtoGenerator generator = context.getBean(DtoGenerator.class);

            generator.generateDTO();

        }

    }

}
