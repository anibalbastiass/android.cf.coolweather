package com.anibalbastias.demo.base.di

import org.kodein.di.Kodein

interface KodeinModuleProvider {
    val kodeinModule: Kodein.Module
}
