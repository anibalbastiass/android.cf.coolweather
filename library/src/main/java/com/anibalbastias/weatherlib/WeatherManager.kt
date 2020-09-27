package com.anibalbastias.weatherlib

import android.app.Application
import com.anibalbastias.weatherlib.data.dataModule
import com.anibalbastias.weatherlib.domain.domainModule
import com.anibalbastias.weatherlib.presentation.presentationModule
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule

class WeatherManager(application: Application): KodeinAware {

    companion object {
        const val MODULE_NAME = "WEATHER"
    }

    override val kodein = Kodein.lazy {
        import(androidXModule(application))
        import(appModule)
        import(presentationModule)
        import(domainModule)
        import(dataModule)
    }
}