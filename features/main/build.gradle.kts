import com.volvocars.weather.extenstion.implementationGroup
import com.volvocars.weather.extenstion.testImplementationGroup

plugins {
    id(Plugins.volvocarsLibraryPlugin)
    id(Plugins.volvocarsComposePlugin)
}

dependencies {

    implementation(project(Modules.Core.base))
    implementation(project(Modules.Core.uikit))
    implementation(project(Modules.Core.repository))
    implementation(project(Modules.Core.theme))

    implementationGroup(DependenciesManager.koin.all)
    implementationGroup(DependenciesManager.coroutines.all)
    implementationGroup(DependenciesManager.retrofit.all)
    implementation(DependenciesManager.coil.getCoil())

    testImplementationGroup(DependenciesManager.coroutines.test)
    testImplementationGroup(DependenciesManager.jUnit.all)
    testImplementationGroup(DependenciesManager.androidX.test.all)
    testImplementationGroup(DependenciesManager.mockk.all)

}