buildscript {

    repositories {
        google()
        mavenCentral()
        maven("https://plugins.gradle.org/m2/")
    }

    dependencies {
        classpath(ClassPaths.buildTools)
        classpath(ClassPaths.kotlin)
        classpath(ClassPaths.ktLint)
        classpath(ClassPaths.gradleVersionsChecker)
    }

}

tasks.register<Delete>("clean") {
    delete(rootProject.buildDir)
}