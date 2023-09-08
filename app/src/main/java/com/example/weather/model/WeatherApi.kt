package com.example.weather.model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("data/2.5/weather")
    fun getWeather(
        @Query("lat") lat: String = "42.49",
        @Query("lon") lon: String = "78.39",
        @Query("appid") appid: String = "36cbf21e77603d1848c9293fd5e5ba31",
        @Query("units") units: String = "metric"

    ): Call<WeatherModel>
}