package com.example.weather.ui.mainfragment

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.weather.databinding.ItemWeatherBinding
import com.example.weather.model.WeatherModel
import com.example.weather.model.WeatherModelListItem
import com.example.weather.setImage
import java.text.SimpleDateFormat
import java.util.TimeZone

class MainAdapter(private val weatherList: List<WeatherModelListItem>) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemWeatherBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = weatherList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(weatherList[position])
    }

    inner class ViewHolder(private var binding: ItemWeatherBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(weatherModel: WeatherModelListItem) = with(binding){
            imgWeather.setImage(weatherModel.weather.first().icon)
            tvDt.text = SimpleDateFormat("HH:mm").format(weatherModel.dt * 1000)
            tvIconDescription.text = weatherModel.weather.first().description
            tvTemp.text = "${weatherModel.main.temp}°"
            tvHumidity.text = "${weatherModel.main.humidity}%"
            tvMinTemp.text = "${weatherModel.main.temp_min}°"
            tvMaxTemp.text = "${weatherModel.main.temp_max}°"
        }
    }
}