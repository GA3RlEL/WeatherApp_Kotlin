package com.example.weatherapp

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun TodayForecast(viewModel: WeatherViewModel) {
    var hour = viewModel.hour
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(20))
            .background(viewModel.backgroundSectionColor)
            .padding(20.dp),
    ) {
        Text(
            text = "TODAY'S FORECAST",
            color = viewModel.sectionTitleColor,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.padding(8.dp))
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.Center
        ) {

            for (i in 0..1) {
                Column(
                    modifier = Modifier
                        .clip(RoundedCornerShape(20))
                        .background(viewModel.sectionTitleColor)
                        .padding(10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        text = "${viewModel.data.hourly.time[hour].substring(11)}"
                    )
                    viewModel.GetWeatherIcon(
                        weatherCode = viewModel.data.hourly.weathercode[hour],
                        modifier = Modifier.size(90.dp)
                    )
                    Text(
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        text = "${viewModel.data.hourly.temperature_2m[hour]}°C"
                    )
                }
                Spacer(modifier = Modifier.padding(8.dp))
                hour++

            }
        }
        Spacer(modifier = Modifier.padding(8.dp))
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.Center
        ) {
            for (i in 0..1) {
                Column(
                    modifier = Modifier
                        .clip(RoundedCornerShape(20))
                        .background(viewModel.sectionTitleColor)
                        .padding(10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        text = "${viewModel.data.hourly.time[hour].substring(11)}"
                    )
                    viewModel.GetWeatherIcon(
                        weatherCode = viewModel.data.hourly.weathercode[hour],
                        modifier = Modifier.size(90.dp)
                    )
                    Text(
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        text = "${viewModel.data.hourly.temperature_2m[hour]}°C"
                    )
                }
                Spacer(modifier = Modifier.padding(8.dp))
                hour++

            }
        }
        Spacer(modifier = Modifier.padding(8.dp))
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.Center
        ) {
            for (i in 0..1) {
                Column(
                    modifier = Modifier
                        .clip(RoundedCornerShape(20))
                        .background(viewModel.sectionTitleColor)
                        .padding(10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        text = "${viewModel.data.hourly.time[hour].substring(11)}"
                    )
                    viewModel.GetWeatherIcon(
                        weatherCode = viewModel.data.hourly.weathercode[hour],
                        modifier = Modifier.size(90.dp)
                    )
                    Text(
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        text = "${viewModel.data.hourly.temperature_2m[hour]}°C"
                    )
                }
                Spacer(modifier = Modifier.padding(8.dp))
                hour++

            }
        }


    }
}