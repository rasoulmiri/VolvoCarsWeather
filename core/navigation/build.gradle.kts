import com.volvocars.weather.extenstion.implementationGroup

plugins {
    id(Plugins.volvocarsLibraryPlugin)
}

dependencies {

    implementationGroup(DependenciesManager.androidX.navigation.all)
    implementationGroup(DependenciesManager.koin.all)

    implementation(project(Modules.Feature.main))

    api("androidx.navigation:navigation-compose:2.4.2")
}