package com.example.getirproject

import android.app.Application
import com.facebook.drawee.backends.pipeline.Fresco

class Application : Application() {
    override fun onCreate() {
        super.onCreate()
        Fresco.initialize(this);
    }
}