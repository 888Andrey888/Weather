package com.example.weather.model

import java.io.Serializable

data class WeatherModel(
    var list: List<WeatherModelListItem>
)

data class CurrentWeatherModel(
    var name: String,
    var main: WeatherMainModel,
    var weather: List<IconWeatherModel>
) : Serializable

data class WeatherModelListItem(
    var dt: Long,
    var main: WeatherMainModel,
    var weather: List<IconWeatherModel>
)

data class IconWeatherModel(
    var description: String,
    var icon: String
)

data class WeatherMainModel(
    var temp: Double,
    var feels_like: Double,
    var temp_min: Double,
    var temp_max: Double,
    var humidity: Int
)
