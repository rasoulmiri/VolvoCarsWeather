package com.volvocars.weather.main.presenter.views.card

import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.volvocars.weather.main.R
import com.volvocars.weather.theme.VolvoCarsTemplateTheme

@Composable
fun WeatherCardView(itemData: WeatherCardModel) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1f),
        shape = MaterialTheme.shapes.medium,
        elevation = 1.dp,
        backgroundColor = MaterialTheme.colors.surface
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column(Modifier.padding(8.dp)) {
                Text(
                    text = itemData.name,
                    style = MaterialTheme.typography.h5,
                    modifier = Modifier
                        .padding(bottom = 8.dp)
                        .fillMaxWidth(),
                    color = MaterialTheme.colors.onSurface,
                )



                when (itemData.state) {
                    WeatherCardState.Loading -> CircularProgressIndicator()
                    WeatherCardState.Success -> {
                        val temperature = itemData.data?.theTemp?.toInt()
                        Text(text = temperature?.toString() ?: kotlin.run { "..." },
                            style = MaterialTheme.typography.body2,
                            modifier = Modifier.padding(bottom = 4.dp))
                    }
                    WeatherCardState.Failed -> Button(onClick = {
                        // TODO add retry logic
                    }) {
                        Text(text = stringResource(R.string.retry))
                    }
                }
                AsyncImage(
                    model = itemData.image,
                    contentDescription = null
                )
            }
        }

    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO, showBackground = true, name = "Light mode")
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true, name = "Dark mode")
@Composable
fun PlanetCardPreview() {
    VolvoCarsTemplateTheme {
        WeatherCardView(WeatherCardModel("Berlin", 1001, WeatherCardState.Loading, null))
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO, showBackground = true, name = "Light mode")
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true, name = "Dark mode")
@Composable
fun PlanetCard1Preview() {
    VolvoCarsTemplateTheme {
        WeatherCardView(WeatherCardModel("Berlin", 1001, WeatherCardState.Loading, null))
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO, showBackground = true, name = "Light mode")
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true, name = "Dark mode")
@Composable
fun PlanetCard2Preview() {
    VolvoCarsTemplateTheme {
        WeatherCardView(WeatherCardModel("Berlin", 1001, WeatherCardState.Loading, null))
    }
}