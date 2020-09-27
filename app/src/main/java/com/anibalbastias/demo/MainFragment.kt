package com.anibalbastias.demo

import android.os.Bundle
import android.view.View
import com.anibalbastias.demo.base.fragment.BaseContainerFragment
import com.anibalbastias.demo.base.navigation.NavManager
import org.kodein.di.generic.instance

class MainFragment : BaseContainerFragment() {

    override val layoutResourceId = R.layout.fragment_main
    private val navManager: NavManager by instance()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}
