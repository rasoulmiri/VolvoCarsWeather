import com.volvocars.weather.extenstion.implementationGroup

plugins {
    id(Plugins.volvocarsApplicationPlugin)
    id(Plugins.volvocarsComposePlugin)
}

dependencies {

    // Modules
    implementation(project(Modules.Core.base))
    implementation(project(Modules.Core.uikit))
    implementation(project(Modules.Core.repository))
    implementation(project(Modules.Core.navigation))
    implementation(project(Modules.Core.theme))

    // Features
    implementation(project(Modules.Feature.main))
    implementation(project(Modules.Feature.details))

    implementationGroup(DependenciesManager.androidX.general.all)
    implementationGroup(DependenciesManager.koin.all)
    implementationGroup(DependenciesManager.coroutines.all)
    implementationGroup(DependenciesManager.retrofit.all)
    implementationGroup(DependenciesManager.androidX.navigation.all)

}