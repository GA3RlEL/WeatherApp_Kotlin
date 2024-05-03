package com.example.weatherapp

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MainScreen(viewModel: WeatherViewModel) {

    Column(
        Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        Column {
            SearchBar(viewModel)
        }


        when (viewModel.isLoading) {
            true -> {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    CircularProgressIndicator()
                }

            }

            false -> {

                when (viewModel.isSearching) {
                    true -> {
                        when (viewModel.isLoadingSearching) {
                            true -> {
                                Column(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .padding(24.dp),
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    verticalArrangement = Arrangement.Center
                                ) {
                                    CircularProgressIndicator()
                                }
                            }

                            false -> {
                                LazyColumn(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .padding(24.dp),
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    for (item in viewModel.townData.results) {
                                        item {
                                            Button(onClick = {
                                                viewModel.isSearching = false
                                                viewModel.town = item.name
                                                viewModel.fetchWeather(
                                                    item.latitude,
                                                    item.longitude
                                                )
                                                viewModel.updateText("")
                                                
                                            }) {
                                                AsyncImage(
                                                    model = "https://flagsapi.com/${item.country_code}/flat/64.png",
                                                    contentDescription = "${item.country_code}",
                                                )
                                                Spacer(modifier = Modifier.padding(8.dp))
                                                Text(text = "${item.name}")
                                            }
                                            Spacer(modifier = Modifier.padding(4.dp))
                                        }

                                    }

                                }
                            }
                        }


                    }

                    false -> {
                        LazyColumn(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(24.dp), horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            item {
                                Text(
                                    text = viewModel.town,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 28.sp,
                                    color = viewModel.textColor
                                )
                            }
                            item { Spacer(modifier = Modifier.padding(8.dp)) }
                            item {
                                Text(
                                    text = "${viewModel.data.hourly.temperature_2m[viewModel.hour]}°C",
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 40.sp,
                                    color = viewModel.textColor
                                )
                            }

                            item {

                                viewModel.GetWeatherIcon(
                                    weatherCode = viewModel.data.hourly.weathercode[viewModel.hour],
                                    modifier = Modifier.size(240.dp)
                                )
                            }

                            item { UvSection(viewModel = viewModel) }

                            item {
                                Spacer(modifier = Modifier.padding(12.dp))
                            }

                            item {
                                WindSection(viewModel = viewModel)
                            }

                            item {
                                Spacer(modifier = Modifier.padding(12.dp))
                            }

                            item {
                                DailyForecast(viewModel = viewModel)
                            }

                            item {
                                Spacer(modifier = Modifier.padding(12.dp))
                            }
                            item {
                                TodayForecast(viewModel = viewModel)
                            }


                        }
                    }
                }


            }
        }
    }


}


