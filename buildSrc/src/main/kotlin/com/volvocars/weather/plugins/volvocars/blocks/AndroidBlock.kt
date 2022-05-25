package com.volvocars.weather.plugins.volvocars.blocks

import com.volvocars.weather.extenstion.android
import org.gradle.api.JavaVersion
import org.gradle.api.Project


object Build {

    const val minSdk = 23
    const val compileSdk = 32
    const val targetSdk = 32

    val javaVersion = JavaVersion.VERSION_1_8
}

fun Project.setupAndroidBlock(isApplication: Boolean) {

    android.run {

        compileSdkVersion(Build.compileSdk)

        defaultConfig {

            minSdkVersion(Build.minSdk)
            targetSdkVersion(Build.targetSdk)

            if (isApplication) {
                applicationId(com.volvocars.weather.applicationConfig.ApplicationId.applicationId)
            }

            versionCode(com.volvocars.weather.applicationConfig.ApplicationId.versionCode)
            versionName(com.volvocars.weather.applicationConfig.ApplicationId.versionName)

            vectorDrawables.useSupportLibrary = true

            multiDexEnabled = true

            flavorDimensions("default")

            testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        }

        testOptions {
            unitTests {
                isReturnDefaultValues = true
                isIncludeAndroidResources = true
            }
            animationsDisabled = true
            resources
        }

        dexOptions {
            incremental = true
            javaMaxHeapSize = "4g"
        }

        compileOptions {
            sourceCompatibility = Build.javaVersion
            targetCompatibility = Build.javaVersion
        }
    }
}



