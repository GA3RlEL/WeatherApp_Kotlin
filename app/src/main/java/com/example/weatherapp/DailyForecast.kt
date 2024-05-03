package com.example.weatherapp

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import java.util.Locale

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun DailyForecast(viewModel: WeatherViewModel) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(20))
            .background(viewModel.backgroundSectionColor)
            .padding(20.dp),
    ) {
        Row(
        ) {
            Text(
                text = "7 DAYS FORECAST",
                color = viewModel.sectionTitleColor,
                fontWeight = FontWeight.Bold
            )
        }
        Spacer(modifier = Modifier.padding(8.dp))
        Column(
        ) {
            for (i in 0..6) {
                val day = viewModel.day.plus(i.toLong())
                when (i) {
                    0 -> {

                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Row() {
                                Text(
                                    color = Color.White,
                                    text = "Today",
                                    fontWeight = FontWeight.Bold
                                )
                                viewModel.GetWeatherIcon(
                                    weatherCode = viewModel.data.daily.weathercode[i].toInt(),
                                    modifier = Modifier.size(30.dp)
                                )
                                Text(
                                    color = Color.White,
                                    text = "${viewModel.data.daily.precipitation_probability_max[i].toInt()}%",
                                    fontWeight = FontWeight.Bold
                                )
                            }
                            Row {
                                Text(
                                    color = Color.White,
                                    text = "${viewModel.data.daily.temperature_2m_max[i]}",
                                    fontWeight = FontWeight.Bold
                                )
                                Spacer(modifier = Modifier.padding(4.dp))
                                Text(
                                    color = Color.White,
                                    text = "${viewModel.data.daily.temperature_2m_min[i]}",
                                    fontWeight = FontWeight.Bold
                                )
                            }


                        }

                    }

                    else -> {
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Row() {
                                Text(
                                    color = Color.White,
                                    text = "${day.name.toLowerCase(Locale.ROOT).capitalize()}",
                                    fontWeight = FontWeight.Bold
                                )
                                viewModel.GetWeatherIcon(
                                    weatherCode = viewModel.data.daily.weathercode[i].toInt(),
                                    modifier = Modifier.size(30.dp)
                                )
                                Text(
                                    color = Color.White,
                                    text = "${viewModel.data.daily.precipitation_probability_max[i].toInt()}%",
                                    fontWeight = FontWeight.Bold
                                )
                            }
                            Row {
                                Text(
                                    color = Color.White,
                                    text = "${viewModel.data.daily.temperature_2m_max[i]}",
                                    fontWeight = FontWeight.Bold
                                )
                                Spacer(modifier = Modifier.padding(4.dp))
                                Text(
                                    color = Color.White,
                                    text = "${viewModel.data.daily.temperature_2m_min[i]}",
                                    fontWeight = FontWeight.Bold
                                )
                            }


                        }
                    }
                }

            }
        }

    }
}