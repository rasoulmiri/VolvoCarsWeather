package com.volvocars.weather.dependencies.groups

class Retrofit {

    private object Versions {
        const val retrofitVersion = "2.6.2"
        const val retrofitConverterGsonVersion = "2.6.2"
        const val retrofitConverterScalarsVersion = "2.1.0"
        const val retrofitAdapterRxJava2Version = "2.6.2"
        const val okhttp3LoggingInterceptorVersion = "3.12.0"
        const val okLogVersion = "2.3.0"
        const val gsonVersion = "2.8.5"
    }

    private object Dependencies {
        const val retrofit =
            "com.squareup.retrofit2:retrofit:${Versions.retrofitVersion}"
        const val retrofitConverterGson =
            "com.squareup.retrofit2:converter-gson:${Versions.retrofitConverterGsonVersion}"
        const val retrofitConverterScalars =
            "com.squareup.retrofit2:converter-scalars:${Versions.retrofitConverterScalarsVersion}"
        const val retrofitAdapterRxJava2 =
            "com.squareup.retrofit2:adapter-rxjava2:${Versions.retrofitAdapterRxJava2Version}"
        const val okhttp3LoggingInterceptor =
            "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp3LoggingInterceptorVersion}"
        const val okLog =
            "com.github.simonpercic:oklog3:${Versions.okLogVersion}"
        const val gson =
            "com.google.code.gson:gson:${Versions.gsonVersion}"
    }

    val all = arrayOf(
        Dependencies.retrofit,
        Dependencies.retrofitConverterGson,
        Dependencies.retrofitConverterScalars,
        Dependencies.retrofitAdapterRxJava2,
        Dependencies.okhttp3LoggingInterceptor,
        Dependencies.okLog,
        Dependencies.gson,
    )

    fun gson(): String {
        return Dependencies.gson
    }
}