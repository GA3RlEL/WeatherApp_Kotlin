package com.example.weatherapp

data class Weather(
    val latitude: Double,
    val longitude: Double,
    val hourly: Hourly,
    val daily: Daily
) {
    data class Hourly(
        val time: List<String>,
        val weathercode: List<Int>,
        val temperature_2m: List<Double>,
        val windspeed_10m: List<Double>
    )

    data class Daily(
        val uv_index_max: List<Double>,
        val temperature_2m_max: List<Double>,
        val temperature_2m_min: List<Double>,
        val weathercode: List<Double>,
        val precipitation_probability_max: List<Double>

    )

}