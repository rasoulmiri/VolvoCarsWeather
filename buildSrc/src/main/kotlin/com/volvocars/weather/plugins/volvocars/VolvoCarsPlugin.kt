package com.volvocars.weather.plugins.volvocars

import Plugins
import com.volvocars.weather.plugins.volvocars.blocks.setupAndroidBlock
import com.volvocars.weather.plugins.volvocars.blocks.setupBuildTypesBlock
import com.volvocars.weather.plugins.volvocars.blocks.setupFlavorBlock
import org.gradle.api.Plugin
import org.gradle.api.Project

internal abstract class VolvoCarsPlugin(private val isApplication: Boolean) : Plugin<Project> {

    override fun apply(project: Project) = with(project) {
        applyPlugins()
        androidConfig()
    }

    private fun Project.applyPlugins() {
        plugins.run {
            if (isApplication) {
                apply(Plugins.androidApplication)
            } else {
                apply(Plugins.androidLibrary)
            }
            apply(Plugins.kotlinAndroid)
            apply(Plugins.kotlinKapt)
            apply(Plugins.ktLint)
            apply(Plugins.gradleVersionsChecker)
        }
    }

    private fun Project.androidConfig() {

        setupAndroidBlock(isApplication = isApplication)
        setupBuildTypesBlock(isApplication = isApplication)
        setupFlavorBlock(isApplication = isApplication)

    }

}

