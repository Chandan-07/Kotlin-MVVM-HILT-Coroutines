package com.example.codewithcb

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class CodeWithCBApplication: Application() {

    override fun onCreate() {
        super.onCreate()
    }
}