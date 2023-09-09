package com.example.weather.presenter

import android.util.Log
import com.example.weather.model.CurrentWeatherModel
import com.example.weather.model.WeatherApi
import com.example.weather.model.WeatherModel
import com.example.weather.model.WeatherModelListItem
import com.example.weather.view.MainView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class MainPresenter @Inject constructor(private val weatherApi: WeatherApi) {

    private lateinit var mainView: MainView

    fun getCurrentWeather() {
        weatherApi.getCurrentWeather().enqueue(object : Callback<CurrentWeatherModel>{
            override fun onResponse(call: Call<CurrentWeatherModel>, response: Response<CurrentWeatherModel>) {
                response.body()?.let { mainView.showCurrentWeather(it) }
            }

            override fun onFailure(call: Call<CurrentWeatherModel>, t: Throwable) {
                mainView.showError(t.message.toString())
            }

        })
    }

    fun getWeatherList(){
        weatherApi.getWeather().enqueue(object : Callback<WeatherModel>{
            override fun onResponse(call: Call<WeatherModel>, response: Response<WeatherModel>) {
                response.body()?.let { mainView.initRecyclerView(it) }
            }

            override fun onFailure(call: Call<WeatherModel>, t: Throwable) {
                mainView.showError(t.message.toString())
            }

        })
    }

    fun attachView(mainView: MainView) {
        this.mainView = mainView
    }
}