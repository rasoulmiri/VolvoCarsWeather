import com.volvocars.weather.extenstion.implementationGroup

plugins {
    id(Plugins.volvocarsLibraryPlugin)
}

dependencies {

    implementation(project(Modules.Core.base))

    implementationGroup(DependenciesManager.androidX.navigation.all)
    implementationGroup(DependenciesManager.koin.all)
    api("androidx.navigation:navigation-compose:2.4.2")
}