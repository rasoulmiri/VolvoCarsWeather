plugins {
    `kotlin-dsl`
}

repositories {
    google()
    mavenCentral()
    maven { url = uri("https://plugins.gradle.org/m2/") }
}

gradlePlugin {
    plugins {

        // VolvoCars Application Plugin
        register("com.volvocars.application.plugin") {
            id = "com.volvocars.application.plugin"
            implementationClass = "com.volvocars.weather.plugins.volvocars.VolvoCarsApplicationPlugin"
        }

        // VolvoCars Library Plugin
        register("com.volvocars.library.plugin") {
            id = "com.volvocars.library.plugin"
            implementationClass = "com.volvocars.weather.plugins.volvocars.VolvoCarsLibraryPlugin"
        }

        // VolvoCars Compose Plugin
        register("com.volvocars.compose.plugin") {
            id = "com.volvocars.compose.plugin"
            implementationClass = "com.volvocars.weather.plugins.volvocars.VolvoCarsComposePlugin"
        }
    }
}

dependencies {

    /**
     * if you change, you need to update this variable [ClassPaths.buildToolsVersion]
     */
    implementation("com.android.tools.build:gradle:7.2.0")

    /**
     * if you change, you need to update this variable [ClassPaths.kotlinVersion]
     */
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.10")
}