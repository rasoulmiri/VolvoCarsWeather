import com.volvocars.weather.extenstion.implementationGroup

plugins {
    id(Plugins.volvocarsLibraryPlugin)
    id(Plugins.volvocarsComposePlugin)
}

dependencies {

    implementation(project(Modules.Core.base))
    implementation(project(Modules.Core.uikit))
    implementation(project(Modules.Core.repository))

    implementationGroup(DependenciesManager.koin.all)
    implementationGroup(DependenciesManager.coroutines.all)
    implementationGroup(DependenciesManager.retrofit.all)
    implementationGroup(DependenciesManager.androidX.navigation.all)
    implementationGroup(DependenciesManager.androidX.general.all)

}