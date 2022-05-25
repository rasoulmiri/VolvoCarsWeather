import com.volvocars.weather.dependencies.groups.*
import com.volvocars.weather.dependencies.groups.androidx.AndroidX
import com.volvocars.weather.dependencies.groups.compose.Compose


object DependenciesManager {

    val koin: Koin by lazy { Koin() }
    val retrofit: Retrofit by lazy { Retrofit() }
    val androidX: AndroidX by lazy { AndroidX() }
    val coroutines: Coroutines by lazy { Coroutines() }
    val mockk: Mockk by lazy { Mockk() }
    val espresso: Espresso by lazy { Espresso() }
    val compose: Compose by lazy { Compose() }
    val jUnit: JUnit by lazy { JUnit() }

}