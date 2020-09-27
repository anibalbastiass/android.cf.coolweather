package com.anibalbastias.demo

import android.app.Application
import android.content.Context
import com.anibalbastias.demo.base.di.kodein.FragmentArgsExternalSource
import com.anibalbastias.demo.base.navigation.navigationModule
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import timber.log.Timber

class MainApplication : Application(), KodeinAware {

    companion object {
        lateinit var appContext: Context
    }

    override val kodein = Kodein.lazy {
        import(androidXModule(this@MainApplication))
//        import(wifiModule)
        import(navigationModule)
        externalSources.add(FragmentArgsExternalSource())
    }

    private lateinit var context: Context

    override fun onCreate() {
        super.onCreate()

        context = this
        appContext = this

        initTimber()
    }

    private fun initTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}
