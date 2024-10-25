package com.example.musinsa

import android.app.Application
import com.airbnb.mvrx.Mavericks
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MusinsaApplication : Application(){
    override fun onCreate() {
        super.onCreate()
        Mavericks.initialize(this)
    }
}
