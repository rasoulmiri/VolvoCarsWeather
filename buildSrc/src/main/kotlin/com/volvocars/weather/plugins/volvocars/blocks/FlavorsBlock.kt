package com.volvocars.weather.plugins.volvocars.blocks

import com.volvocars.weather.extenstion.addConfigField
import com.volvocars.weather.extenstion.addDoubleQuotation
import com.volvocars.weather.extenstion.android
import org.gradle.api.Project


object FlavorName {
    const val googlePlay = "googlePlay"
    const val UAT = "UAT"
}

object FlavorBuildConfigField {

    object AppStoreName {

        object Key {
            const val appStoreName = "APP_STORE_NAME"
        }

        object Value {
            const val googlePlay = "GooglePlay"
            const val UAT = "UAT"
        }
    }

    object AppStoreUrl {

        object Key {
            const val appStoreUrl = "APP_STORE_URL"
        }

        object Value {
            const val googlePlay =
                "https://play.google.com/store/apps/details?id=com.volvocars.weather"
            const val UAT = "https://volvocars.com"
        }
    }

}

fun Project.setupFlavorBlock(isApplication: Boolean) {
    android.run {
        productFlavors {

            create(FlavorName.googlePlay) {
                addConfigField(
                    key = FlavorBuildConfigField.AppStoreName.Key.appStoreName,
                    value = FlavorBuildConfigField.AppStoreName.Value.googlePlay.addDoubleQuotation()
                )
                addConfigField(
                    key = FlavorBuildConfigField.AppStoreUrl.Key.appStoreUrl,
                    value = FlavorBuildConfigField.AppStoreUrl.Value.googlePlay.addDoubleQuotation()
                )
            }

            create(FlavorName.UAT) {
                addConfigField(
                    key = FlavorBuildConfigField.AppStoreName.Key.appStoreName,
                    value = FlavorBuildConfigField.AppStoreName.Value.UAT.addDoubleQuotation()
                )
                addConfigField(
                    key = FlavorBuildConfigField.AppStoreUrl.Key.appStoreUrl,
                    value = FlavorBuildConfigField.AppStoreUrl.Value.UAT.addDoubleQuotation()
                )
            }
        }
    }
}