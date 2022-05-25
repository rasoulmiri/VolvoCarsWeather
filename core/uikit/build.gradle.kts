import com.volvocars.weather.extenstion.implementationGroup

plugins {
    id(Plugins.volvocarsLibraryPlugin)
    id(Plugins.volvocarsComposePlugin)
}

dependencies {
    implementationGroup(DependenciesManager.androidX.general.all)
    implementationGroup(DependenciesManager.androidX.navigation.all)
    implementationGroup(DependenciesManager.coroutines.all)
}
