package com.volvocars.weather.details.presenter.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.volvocars.weather.details.R
import com.volvocars.weather.details.presenter.navigation.DetailsNavigationModel

@Composable
fun DetailsView(navigationModel: DetailsNavigationModel?) {

    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = MaterialTheme.colors.primary,
                title = { Text(navigationModel?.cityName ?: "NON") }
            )
        }
    ) {
        Column(modifier = Modifier.padding(8.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(painter = painterResource(R.drawable.ic_thermometer),
                    contentDescription = null)
                Text(text = "Temperature: ")
                Text(text = navigationModel?.temperature ?: "-")
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row {
                Image(painter = painterResource(R.drawable.ic_thermometer_chevron_down),
                    contentDescription = null)
                Text(text = "Minimum Temperature: ")
                Text(text = navigationModel?.temperatureMin ?: "-")
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row {
                Image(painter = painterResource(R.drawable.ic_thermometer_chevron_up),
                    contentDescription = null)
                Text(text = "Maximum Temperature: ")
                Text(text = navigationModel?.temperatureMax ?: "-")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    DetailsView(null)
}