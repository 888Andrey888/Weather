package com.example.weather.model

import java.io.Serializable

data class WeatherModel(
    var name: String,
    var main: WeatherMainModel
) : Serializable

data class WeatherMainModel (
    var temp: Double,
    var feels_like: Double,
    var temp_min: Double,
    var temp_max: Double,
    var humidity: Int
)
