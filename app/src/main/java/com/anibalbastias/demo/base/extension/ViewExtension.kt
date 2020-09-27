package com.anibalbastias.demo.base.extension

import android.app.Activity
import android.content.Context
import android.view.View
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

object ViewExtension {

    fun Toolbar.setArrowUpToolbar(context: Activity) {
        (context as AppCompatActivity).setSupportActionBar(this)
        context.supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

    fun Toolbar.setNoArrowUpToolbar(context: Activity) {
        (context as AppCompatActivity).setSupportActionBar(this)
        context.supportActionBar!!.setDisplayHomeAsUpEnabled(false)
    }

    fun View.visible() {
        this.visibility = View.VISIBLE
    }

    fun View.gone() {
        this.visibility = View.GONE
    }

    fun View.invisible() {
        this.visibility = View.INVISIBLE
    }

    fun Context.toast(@StringRes resId: Int, length: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(this, getString(resId), length).show()
    }

    fun Context.toast(text: String, length: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(this, text, length).show()
    }
}