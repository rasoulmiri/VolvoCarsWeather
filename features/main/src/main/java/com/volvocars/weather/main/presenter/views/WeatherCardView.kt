package com.volvocars.weather.main.presenter.views

import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.volvocars.weather.main.R
import com.volvocars.weather.main.presenter.WeatherCardModel
import com.volvocars.weather.main.presenter.WeatherCardState
import com.volvocars.weather.theme.VolvoCarsTemplateTheme


@Composable
fun WeatherCard(itemData: WeatherCardModel) {
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
                val temperature = itemData.data?.theTemp?.toInt()
                Text(
                    text = temperature?.toString() ?: kotlin.run { "..." },
                    style = MaterialTheme.typography.body2,
                    modifier = Modifier.padding(bottom = 4.dp))

                when (itemData.state) {
                    WeatherCardState.Loading -> CircularProgressIndicator()
                    WeatherCardState.Success -> {}
                    WeatherCardState.Failed -> Button(onClick = {
                        // TODO add retry logic
                    }) {
                        Text(text = stringResource(R.string.retry))
                    }
                }
//                Image(
//                    painter = painterResource(id =),
//                    contentDescription = null,
//                    modifier = Modifier
//                        .size(60.dp)
//                        .padding(8.dp),
//                    contentScale = ContentScale.Fit,
//                )
            }
        }

    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO, showBackground = true, name = "Light mode")
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true, name = "Dark mode")
@Composable
fun PlanetCardPreview() {
    VolvoCarsTemplateTheme {
//        WeatherCard()
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO, showBackground = true, name = "Light mode")
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true, name = "Dark mode")
@Composable
fun PlanetCard1Preview() {
//    VolvoCarsTemplateTheme {
//        WeatherCard(plants[1].name, plants[1].description, plants[1].imageRes)
//    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO, showBackground = true, name = "Light mode")
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true, name = "Dark mode")
@Composable
fun PlanetCard2Preview() {
//    VolvoCarsTemplateTheme {
//        WeatherCard(plants[2].name, plants[2].description, plants[2].imageRes)
//    }
}