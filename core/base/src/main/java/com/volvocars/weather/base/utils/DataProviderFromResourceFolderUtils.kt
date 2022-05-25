package com.volvocars.weather.base.utils

import com.google.gson.Gson


class DataProviderFromResourceFolderUtils {

    companion object {

        inline fun <reified T> getModelFromFileResource(filePath: String, clazz: Class<T>): T {
            val json = javaClass.classLoader?.getResourceAsStream(filePath)
                ?.bufferedReader().use { it?.readText().orEmpty() }
            return Gson().fromJson(json, clazz)
        }

    }
}