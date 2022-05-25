object ClassPaths {

    /**
     * if you change, you need to update in this variable
     * ../buildSrc/build.gradle.kts
     **/
    private const val kotlinVersion = "1.6.10"

    /**
     * if you change, you need to update in this variable
     * ../buildSrc/build.gradle.kts
     **/
    private const val buildToolsVersion = "7.2.0"
    private const val ktLintVersion = "10.0.0"
    private const val gradleVersionsCheckerVersion = "0.42.0"

    const val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion"
    const val buildTools = "com.android.tools.build:gradle:$buildToolsVersion"
    const val ktLint = "org.jlleitschuh.gradle:ktlint-gradle:$ktLintVersion"
    const val gradleVersionsChecker =
        "com.github.ben-manes:gradle-versions-plugin:$gradleVersionsCheckerVersion"
}
