package com.example.weatherapp

data class Town(var results: List<Town_info>) {
    data class Town_info(
        var country_code: String,
        var name: String,
        var latitude: Double,
        var longitude: Double
    )
}

