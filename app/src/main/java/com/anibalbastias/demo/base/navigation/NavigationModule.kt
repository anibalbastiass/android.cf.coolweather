package com.anibalbastias.demo.base.navigation

import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.singleton

internal const val MODULE_NAME = "Navigation"

val navigationModule = Kodein.Module("${MODULE_NAME}Module") {

    bind() from singleton { NavManager() }
}
