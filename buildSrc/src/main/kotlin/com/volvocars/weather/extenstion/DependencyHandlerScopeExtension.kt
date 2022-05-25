package com.volvocars.weather.extenstion

import org.gradle.kotlin.dsl.DependencyHandlerScope

fun DependencyHandlerScope.implementationGroup(list: Array<String>) {
    list.map {
        "implementation"(it)
    }
}

fun DependencyHandlerScope.debugImplementationGroup(list: Array<String>) {
    list.map {
        "debugImplementation"(it)
    }
}

fun DependencyHandlerScope.testImplementationGroup(vararg list: String) {
    list.map {
        "testImplementation"(it)
    }
}
