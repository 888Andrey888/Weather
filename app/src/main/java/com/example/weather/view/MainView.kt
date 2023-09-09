package com.example.weather.view

import com.example.weather.model.CurrentWeatherModel
import com.example.weather.model.WeatherModel

interface MainView {

    fun showCurrentWeather(currentWeatherModel: CurrentWeatherModel)
    fun showError(message: String)
    fun initRecyclerView(weatherModel: WeatherModel)

}