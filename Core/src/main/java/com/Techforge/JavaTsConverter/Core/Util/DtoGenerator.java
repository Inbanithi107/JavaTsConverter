package com.Techforge.JavaTsConverter.Core.Util;

import com.Techforge.JavaTsConverter.Core.JavaTypescriptGenerator;
import cz.habarta.typescript.generator.*;
import org.springframework.stereotype.Component;

import java.io.File;
import java.nio.file.FileSystemException;

@Component
public class DtoGenerator {

    private final JavaTypescriptGenerator javaTypescriptGenerator;

    private final ClassScanner classScanner;

    private TypeScriptGenerator typeScriptGenerator;

    private Settings settings;

    private Input input;

    private Output output;

    public DtoGenerator(JavaTypescriptGenerator javaTypescriptGenerator, ClassScanner classScanner){
        this.javaTypescriptGenerator=javaTypescriptGenerator;
        this.classScanner = classScanner;
    }

    public void generateDTO(){


        File directory = javaTypescriptGenerator.getOutputDir();
        try {
            directory.mkdirs();
            typeScriptGenerator = new TypeScriptGenerator(getSettings());
            for(Class<?> file : classScanner.getAnnotatedClasses()){
                input = Input.from(file);
                output = Output.to(new File(directory, file.getSimpleName()+".ts"));
                typeScriptGenerator.generateTypeScript(input,output);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    public Settings getSettings(){
        settings = new Settings();
        settings.outputKind = TypeScriptOutputKind.module;
        settings.outputFileType = TypeScriptFileType.implementationFile;
        settings.jsonLibrary = JsonLibrary.jackson2;
        return settings;
    }

}
