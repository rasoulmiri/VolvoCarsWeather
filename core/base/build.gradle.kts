import com.volvocars.weather.extenstion.implementationGroup

plugins {
    id(Plugins.volvocarsLibraryPlugin)
}

dependencies {

    implementationGroup(DependenciesManager.coroutines.all)
    implementationGroup(DependenciesManager.retrofit.all)
    implementationGroup(DependenciesManager.androidX.navigation.all)
    implementationGroup(DependenciesManager.koin.all)

}