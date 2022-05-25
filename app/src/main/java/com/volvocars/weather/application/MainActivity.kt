package com.volvocars.weather.application

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import com.volvocars.weather.theme.VolvoCarsTemplateTheme


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VolvoCarsWeatherApp {
                Navigation()
            }
        }
    }

    @Composable
    fun VolvoCarsWeatherApp(content: @Composable () -> Unit) {
        VolvoCarsTemplateTheme {
            content()
        }
    }
}
