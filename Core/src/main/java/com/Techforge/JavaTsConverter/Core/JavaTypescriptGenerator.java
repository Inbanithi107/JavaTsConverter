package com.Techforge.JavaTsConverter.Core;

import java.io.File;

public class JavaTypescriptGenerator {

    private String basePackage;

    private File outputDir;

    public JavaTypescriptGenerator(String basePackage, File outputDir) {
        this.basePackage = basePackage;
        this.outputDir = outputDir;
    }

    public String getBasePackage() {
        return basePackage;
    }

    public void setBasePackage(String basePackage) {
        this.basePackage = basePackage;
    }

    public File getOutputDir() {
        return outputDir;
    }

    public void setOutputDir(File outputDir) {
        this.outputDir = outputDir;
    }

    public JavaTypescriptGenerator() {
    }
}
