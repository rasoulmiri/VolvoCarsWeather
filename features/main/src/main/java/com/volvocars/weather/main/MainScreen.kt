package com.volvocars.weather.main

import androidx.compose.foundation.clickable
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController

@Composable
fun MainScreen(navController: NavController) {
    Scaffold {
        ClickableText("Button") {}
    }
}

@Composable
fun ClickableText(name: String, onclick: () -> Unit) {
    Text(
        modifier = Modifier.clickable {
            onclick.invoke()
        },
        text = name
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ClickableText("Android") { }
}
