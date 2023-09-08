package com.example.weather.presenter

import android.util.Log
import com.example.weather.model.WeatherApi
import com.example.weather.model.WeatherModel
import com.example.weather.view.MainView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class MainPresenter @Inject constructor(private val weatherApi: WeatherApi) {

    private lateinit var mainView: MainView

    fun getWeather() {
        weatherApi.getWeather().enqueue(object : Callback<WeatherModel>{
            override fun onResponse(call: Call<WeatherModel>, response: Response<WeatherModel>) {
                response.body()?.let { mainView.showWeather(it) }
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