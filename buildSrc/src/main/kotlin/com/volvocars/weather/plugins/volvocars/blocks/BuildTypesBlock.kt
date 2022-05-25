package com.volvocars.weather.plugins.volvocars.blocks

import com.volvocars.weather.extenstion.addConfigField
import com.volvocars.weather.extenstion.addDoubleQuotation
import com.volvocars.weather.extenstion.android
import org.gradle.api.Project

object BuildTypeName {
    const val debug = "debug"
    const val release = "release"
}

object BuildConfigField {

    object BaseUrl {

        object Key {
            const val baseUrl = "BASE_URL"
        }

        object Value {
            const val dev = "https://test.com/"
            const val production = "https://test.com/"
        }
    }
}

fun Project.setupBuildTypesBlock(isApplication: Boolean) {
    android.run {

        buildTypes {

            getByName(BuildTypeName.debug) {

                addConfigField(
                    key = BuildConfigField.BaseUrl.Key.baseUrl,
                    value = BuildConfigField.BaseUrl.Value.dev.addDoubleQuotation()
                )

                isDebuggable = true

                if (isApplication) {

                    applicationIdSuffix = ".${BuildTypeName.debug}"

                    // Proguard
                    isMinifyEnabled = false
                    isShrinkResources = false
                }

            }

            getByName(BuildTypeName.release) {

                addConfigField(
                    key = BuildConfigField.BaseUrl.Key.baseUrl,
                    value = BuildConfigField.BaseUrl.Value.production.addDoubleQuotation()
                )

                isDebuggable = false

                if (isApplication) {
                    // Proguard
                    isShrinkResources = true
                    isMinifyEnabled = true
                    proguardFiles(
                        getDefaultProguardFile("proguard-android.txt"),
                        "proguard-rules.pro"
                    )
                }

            }
        }
    }
}

