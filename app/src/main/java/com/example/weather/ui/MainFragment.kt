package com.example.weather.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.weather.R
import com.example.weather.databinding.FragmentMainBinding
import com.example.weather.model.WeatherModel
import com.example.weather.presenter.MainPresenter
import com.example.weather.view.MainView
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainFragment : Fragment(), MainView {

    private lateinit var binding: FragmentMainBinding
    @Inject
    lateinit var presenter: MainPresenter

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
        presenter.getWeather()
    }

    override fun showWeather(weatherModel: WeatherModel) {
        with(binding){
            tvCity.append(" " + weatherModel.name)
            tvCurrentTemp.append(" " + weatherModel.main.temp + "°C")
            tvByFeeling.append(" " + weatherModel.main.feels_like + "°C")
            tvTempMin.append(" " + weatherModel.main.temp_min + "°C")
            tvTempMax.append(" " + weatherModel.main.temp_max + "°C")
            tvHumidity.append(" " + weatherModel.main.humidity + "%")
        }
    }

    override fun showError(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }
}