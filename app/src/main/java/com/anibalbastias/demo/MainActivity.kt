package com.anibalbastias.demo

import android.os.Bundle
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.anibalbastias.demo.base.activity.BaseActivity
import com.anibalbastias.demo.base.navigation.NavManager
import kotlinx.android.synthetic.main.activity_main.*
import org.kodein.di.generic.instance

class MainActivity : BaseActivity() {

    override val layoutResId = R.layout.activity_main

    private val navController get() = navHostFragment.findNavController()

    private val navManager: NavManager by instance()

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)

        initBottomNavigation()
        initNavManager()
    }

    private fun initBottomNavigation() {
        bottomNav.setupWithNavController(navController)
    }

    private fun initNavManager() {
        navManager.setOnNavEvent {
            navController.navigate(it)
        }
    }
}
