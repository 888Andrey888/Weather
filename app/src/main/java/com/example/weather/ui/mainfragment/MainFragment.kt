package com.example.weather.ui.mainfragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.weather.databinding.FragmentMainBinding
import com.example.weather.model.CurrentWeatherModel
import com.example.weather.model.WeatherModel
import com.example.weather.presenter.MainPresenter
import com.example.weather.setImage
import com.example.weather.view.MainView
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainFragment : Fragment(), MainView {

    private lateinit var binding: FragmentMainBinding
    @Inject
    lateinit var presenter: MainPresenter
    private lateinit var adapter: MainAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.attachView(this)
        presenter.getCurrentWeather()
    }

    override fun onResume() {
        presenter.getWeatherList()
        super.onResume()
    }

    override fun showCurrentWeather(currentWeatherModel: CurrentWeatherModel) {
        with(binding){
            tvLocation.text = currentWeatherModel.name
            tvCurrentTemp.text = "${currentWeatherModel.main.temp}°"
            tvCurrentHumidity.text = "${currentWeatherModel.main.humidity}%"
            imgCurrentWeather.setImage(currentWeatherModel.weather.first().icon)
            tvCurrentIconDescription.text = currentWeatherModel.weather.first().description
        }
    }

    override fun showError(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    override fun initRecyclerView(weatherModel: WeatherModel) {
        adapter = MainAdapter(weatherModel.list)
        binding.rvWeather.adapter = adapter
    }
}