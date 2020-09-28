package com.anibalbastias.demo.base.navigation

import androidx.navigation.NavDirections
import java.lang.IllegalStateException

class NavManager {
    private var navEventListener: ((navDirections: NavDirections) -> Unit)? = null

    fun navigate(navDirections: NavDirections) {
        try {
            navEventListener?.invoke(navDirections)
        } catch (e: IllegalStateException) {
            e.printStackTrace()
        }
    }

    fun setOnNavEvent(navEventListener: (navDirections: NavDirections) -> Unit) {
        this.navEventListener = navEventListener
    }
}
