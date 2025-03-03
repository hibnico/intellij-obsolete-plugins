
plugins {
    id("java")
    id("org.jetbrains.intellij.platform") version "2.3.0"
}

group = "com.intellij"
version = "2024.3.4"

repositories {
    mavenCentral()
    intellijPlatform {
        defaultRepositories()
    }
}

dependencies {
    intellijPlatform {
        intellijIdeaUltimate("2024.3.4")

        bundledPlugin("org.intellij.groovy")
        bundledPlugin("com.intellij.persistence")
    }
}

java.sourceSets["main"].java {
    srcDir("src/main/gen")
}

tasks {
    // Set the JVM compatibility versions
    withType<JavaCompile> {
        sourceCompatibility = "21"
        targetCompatibility = "21"
    }
}
