package com.marina.binlist.app

import android.app.Application
import com.marina.binlist.di.component.DaggerAppComponent

class App : Application() {

    val component by lazy {
        DaggerAppComponent.factory().create(this)
    }
}