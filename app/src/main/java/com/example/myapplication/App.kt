package com.example.myapplication

import android.app.Application
import com.example.myapplication.di.*
import org.koin.android.ext.android.startKoin

class App: Application(){


    override fun onCreate() {
        super.onCreate()
        loadKoin()
    }

    private fun loadKoin() {
        startKoin(this@App,
            listOf(repositoryModules,
                networkModules,
                applicationModule,
                fragments,
                viewModels)
        )
    }
}