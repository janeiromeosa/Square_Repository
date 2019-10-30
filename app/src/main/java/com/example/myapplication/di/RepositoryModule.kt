package com.example.myapplication.di

import com.example.myapplication.model.Repository
import org.koin.dsl.module.module

val repositoryModules = module {

    Repository(remoteDataSource = get())
}