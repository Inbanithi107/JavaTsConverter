import java.net.URLClassLoader

plugins {
    id("java-library")
    id("maven-publish")
    id("org.springframework.boot") version "3.4.5"
    id("io.spring.dependency-management") version "1.1.7"
}

group = "com.Techforge.JavaTsConverter"
version = "1.0-SNAPSHOT"

repositories {
    mavenLocal()
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("cz.habarta.typescript-generator:typescript-generator-maven-plugin:3.2.1263")
    api(project(":Annotations"))
    api("org.springframework.boot:spring-boot-starter:3.4.5")
}

tasks.test {
    useJUnitPlatform()
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])
        }
    }
}