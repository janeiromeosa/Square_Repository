package com.example.myapplication.di

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.view.navigation.AppNavigator
import org.koin.dsl.module.module

val applicationModule = module {
    factory { (context:Context)-> AppNavigator(context) }
}

val fragments = module {
//    factory { (activity: AppCompatActivity()) }
}

