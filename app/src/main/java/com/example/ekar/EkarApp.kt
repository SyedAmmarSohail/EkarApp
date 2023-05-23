package com.example.ekar

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class EkarApp : Application() {
    override fun onCreate() {
        appContext = this
        super.onCreate()
    }

    companion object {
        lateinit var appContext: Application
    }
}