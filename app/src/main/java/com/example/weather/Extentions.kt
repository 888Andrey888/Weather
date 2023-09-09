package com.example.weather

import android.widget.ImageView

fun ImageView.setImage(name: String){
    when(name){
        "01d" -> this.setImageResource(R.drawable.ic_01d)
        "01n" -> this.setImageResource(R.drawable.ic_01n)
        "02d" -> this.setImageResource(R.drawable.ic_02d)
        "02n" -> this.setImageResource(R.drawable.ic_02n)
        "03d" -> this.setImageResource(R.drawable.ic_03d)
        "03n" -> this.setImageResource(R.drawable.ic_03n)
        "04d" -> this.setImageResource(R.drawable.ic_04d)
        "04n" -> this.setImageResource(R.drawable.ic_04n)
        "09d" -> this.setImageResource(R.drawable.ic_09d)
        "09n" -> this.setImageResource(R.drawable.ic_09n)
        "10d" -> this.setImageResource(R.drawable.ic_10d)
        "10n" -> this.setImageResource(R.drawable.ic_10n)
        "11d" -> this.setImageResource(R.drawable.ic_11d)
        "11n" -> this.setImageResource(R.drawable.ic_11n)
        "13d" -> this.setImageResource(R.drawable.ic_13d)
        "13n" -> this.setImageResource(R.drawable.ic_13n)
        "50d" -> this.setImageResource(R.drawable.ic_50d)
        "50n" -> this.setImageResource(R.drawable.ic_50n)
    }

}
