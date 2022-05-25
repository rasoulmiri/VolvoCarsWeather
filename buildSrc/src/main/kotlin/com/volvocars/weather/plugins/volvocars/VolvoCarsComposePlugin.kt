package com.volvocars.weather.plugins.volvocars

import DependenciesManager
import com.volvocars.weather.extenstion.android
import com.volvocars.weather.extenstion.debugImplementationGroup
import com.volvocars.weather.extenstion.implementationGroup
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class VolvoCarsComposePlugin : Plugin<Project> {
    override fun apply(project: Project) {
        project.enableCompose()
        project.setupComposeDependencies()
    }
}

private fun Project.enableCompose() {

    android.run {

        buildFeatures.apply {
            compose = true
        }

        composeOptions {
            kotlinCompilerExtensionVersion = DependenciesManager.compose.getComposeVersion()
        }
    }

}

private fun Project.setupComposeDependencies() {
    dependencies {
        implementationGroup(DependenciesManager.compose.all)
        debugImplementationGroup(DependenciesManager.compose.debugImplementation)
    }
}

