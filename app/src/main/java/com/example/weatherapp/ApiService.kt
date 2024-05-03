package com.example.weatherapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

val BASIC_URL = "https://api.open-meteo.com"
val BASIC_URL_2 = "https://geocoding-api.open-meteo.com"

private val retrofit =
    Retrofit.Builder().baseUrl(BASIC_URL).addConverterFactory(GsonConverterFactory.create()).build()

private val retrofit2 =
    Retrofit.Builder().baseUrl(BASIC_URL_2).addConverterFactory(GsonConverterFactory.create())
        .build()

val weatherService = retrofit.create(ApiService::class.java)

val townService = retrofit2.create(ApiService2::class.java)

interface ApiService {
    @GET("/v1/forecast")
    suspend fun getWeather(
        @Query("latitude") lat: Double,
        @Query("longitude") lng: Double,
        @Query("hourly") hourlyParams: String = "temperature_2m,weathercode,windspeed_10m",
        @Query("daily") dailyParams: String = "weathercode,temperature_2m_max,temperature_2m_min,uv_index_max,precipitation_probability_max",
        @Query("timezone") timezone: String = "auto"
    ): Weather
}

interface ApiService2 {
    @GET("/v1/search")
    suspend fun searchLocations(
        @Query("name") name: String,
        @Query("count") count: Int = 10,
        @Query("language") language: String = "en",
        @Query("format") format: String = "json"
    ): Town
}


//https://geocoding-api.open-meteo.com/v1/search?name=${search}&count=10&language=en&format=json