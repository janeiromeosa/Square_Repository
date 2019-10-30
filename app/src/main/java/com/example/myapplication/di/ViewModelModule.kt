package com.example.myapplication.di

import com.example.myapplication.view.SquareReposViewModel
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val viewModels = module {

    viewModel{ SquareReposViewModel (get()) }
}
