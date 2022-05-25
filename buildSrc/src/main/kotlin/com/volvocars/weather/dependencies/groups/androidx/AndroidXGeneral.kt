package com.volvocars.weather.dependencies.groups.androidx

class AndroidXGeneral {

    private object Versions {
        const val material = "1.2.1"
        const val multidex = "2.0.1"
        const val coreKtx = "1.2.0"
        const val recyclerview = "1.1.0"
        const val cardView = "1.0.0"
        const val appcompat = "1.2.0"
        const val legacySupportV4 = "1.0.0"
        const val constraintLayout = "2.0.4"
        const val preferences = "1.1.1"
    }

    private object Dependencies {
        const val material =
            "com.google.android.material:material:${com.volvocars.weather.dependencies.groups.androidx.AndroidXGeneral.Versions.material}"
        const val multiDex =
            "androidx.multidex:multidex:${Versions.multidex}"
        const val coreKtx =
            "androidx.core:core-ktx:${com.volvocars.weather.dependencies.groups.androidx.AndroidXGeneral.Versions.coreKtx}"
        const val recyclerView =
            "androidx.recyclerview:recyclerview:${Versions.recyclerview}"
        const val cardView =
            "androidx.cardview:cardview:${com.volvocars.weather.dependencies.groups.androidx.AndroidXGeneral.Versions.cardView}"
        const val appcompat =
            "androidx.appcompat:appcompat:${com.volvocars.weather.dependencies.groups.androidx.AndroidXGeneral.Versions.appcompat}"
        const val legacySupportV4 =
            "androidx.legacy:legacy-support-v4:${com.volvocars.weather.dependencies.groups.androidx.AndroidXGeneral.Versions.legacySupportV4}"
        const val constraintLayout =
            "androidx.constraintlayout:constraintlayout:${com.volvocars.weather.dependencies.groups.androidx.AndroidXGeneral.Versions.constraintLayout}"
        const val preferences =
            "androidx.preference:preference-ktx:${com.volvocars.weather.dependencies.groups.androidx.AndroidXGeneral.Versions.preferences}"
    }

    val all = arrayOf(
        Dependencies.material,
        Dependencies.multiDex,
        Dependencies.coreKtx,
        Dependencies.recyclerView,
        Dependencies.cardView,
        Dependencies.appcompat,
        Dependencies.legacySupportV4,
        Dependencies.constraintLayout,
        Dependencies.preferences
    )

}