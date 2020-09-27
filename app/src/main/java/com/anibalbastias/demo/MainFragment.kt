package com.anibalbastias.demo

import android.os.Bundle
import android.view.View
import com.anibalbastias.demo.base.fragment.BaseContainerFragment
import com.anibalbastias.demo.base.navigation.NavManager
import com.anibalbastias.weatherlib.WeatherManager
import org.kodein.di.generic.instance

class MainFragment : BaseContainerFragment() {

    override val layoutResourceId = R.layout.fragment_main

    private lateinit var manager: WeatherManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        manager = WeatherManager(MainApplication.application)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}
