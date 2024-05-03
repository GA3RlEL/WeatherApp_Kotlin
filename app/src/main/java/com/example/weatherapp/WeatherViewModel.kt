package com.example.weatherapp

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import java.time.LocalDateTime


class WeatherViewModel : ViewModel() {

    val textColor = Color.White
    val backgroundSectionColor = Color(0xff414652)
    val sectionTitleColor = Color(0xff9ca3af)

    var isSearching by mutableStateOf(false)
    var isLoadingSearching by mutableStateOf(false)
    var isLoading by mutableStateOf(true)

    var lat by mutableStateOf(53.42894)
    var lng by mutableStateOf(14.55302)
    var town by mutableStateOf("Szczecin")

    @RequiresApi(Build.VERSION_CODES.O)
    var hour = LocalDateTime.now().hour

    @RequiresApi(Build.VERSION_CODES.O)
    var day = LocalDateTime.now().dayOfWeek


    var data by mutableStateOf(
        Weather(
            latitude = 0.0, longitude = 0.0, hourly = Weather.Hourly(
                emptyList(),
                emptyList(),
                emptyList(),
                emptyList()
            ), daily = Weather.Daily(
                emptyList(),
                emptyList(),
                emptyList(),
                emptyList(),
                emptyList()
            )
        )
    )

    var townData by mutableStateOf(Town(emptyList()))

    fun fetchWeather(lat: Double, lng: Double) {
        viewModelScope.launch {
            try {
                isLoading = true
                val response =
                    weatherService.getWeather(lat, lng).copy()
                Log.d("Retrofit", "Data: ${response}")
                data = response
                isLoading = false
            } catch (e: Exception) {
                Log.e("Retrofit", "Error: ${e.message}")
                isLoading = false
            }
        }
    }

    fun fetchTowns(townName: String) {
        viewModelScope.launch {
            try {
                isLoadingSearching = true
                val response = townService.searchLocations(townName)
                Log.d("Retrofit", "Data Town: ${response}")
                townData = response
                isLoadingSearching = false
            } catch (e: Exception) {
                Log.e("Retrofit", "Error: ${e.message}")
                isLoadingSearching = false
            }
        }
    }


    init {
        fetchWeather(lat, lng)
    }

    var backgroundColor by mutableStateOf(Color.White)
        private set

    var text by mutableStateOf("")
        private set


    fun changeBackgroundColor() {
        backgroundColor = Color.Red
        println(backgroundColor)
    }

    fun updateText(t: String) {
        text = t
    }

    @RequiresApi(Build.VERSION_CODES.O)
    @Composable
    fun GetWeatherIcon(weatherCode: Int, modifier: Modifier) {
        if (
            (weatherCode in 51..65) ||
            (weatherCode in 80..82)
        )
            return androidx.compose.foundation.Image(
                painter = painterResource(id = R.drawable.rain),
                contentDescription = "rain", modifier
            );

        if (
            (weatherCode in 71..77) ||
            (weatherCode in 85..86)
        )
            return androidx.compose.foundation.Image(
                painter = painterResource(id = R.drawable.snow_foreground),
                contentDescription = "snow", modifier
            )

        if ((hour in 22..23) || (hour in 0..6)) {
            if (weatherCode in 1..3) return androidx.compose.foundation.Image(
                painter = painterResource(
                    id = R.drawable.cloudnight_foreground
                ), contentDescription = "cloudnight", modifier
            )
            else return androidx.compose.foundation.Image(
                painter = painterResource(id = R.drawable.night_foreground),
                contentDescription = "night", modifier
            )
        } else if (hour in 7..21) {
            if (weatherCode in 1..3) return androidx.compose.foundation.Image(
                painter = painterResource(
                    id = R.drawable.cloud_foreground
                ), contentDescription = "cloud", modifier
            )
            else return androidx.compose.foundation.Image(
                painter = painterResource(id = R.drawable.sun_foreground),
                contentDescription = "sun", modifier
            )
        }
        return androidx.compose.foundation.Image(
            painter = painterResource(id = R.drawable.sun_foreground),
            contentDescription = "sun", modifier
        )
    }
}