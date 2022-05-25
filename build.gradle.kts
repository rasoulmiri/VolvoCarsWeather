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
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.21")
    }

}

tasks.register<Delete>("clean") {
    delete(rootProject.buildDir)
}