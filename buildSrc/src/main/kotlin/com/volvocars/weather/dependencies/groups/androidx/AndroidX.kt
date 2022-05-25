package com.volvocars.weather.dependencies.groups.androidx

class AndroidX {

    val navigation: AndroidXNavigation by lazy { AndroidXNavigation() }
    val general: AndroidXGeneral by lazy { AndroidXGeneral() }
    val lifecycle: AndroidXLifecycle by lazy { AndroidXLifecycle() }
    val test: AndroidXTest by lazy { AndroidXTest() }

}