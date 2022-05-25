import com.volvocars.weather.extenstion.implementationGroup

plugins {
    id(Plugins.volvocarsLibraryPlugin)
}

dependencies {

    // Modules
    implementation(project(Modules.Core.base))

    implementationGroup(DependenciesManager.koin.all)
    implementationGroup(DependenciesManager.coroutines.all)
    implementationGroup(DependenciesManager.retrofit.all)

}