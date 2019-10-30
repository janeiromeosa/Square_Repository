package com.example.myapplication.di

import com.example.myapplication.model.Repository
import com.example.myapplication.net.RemoteDataSource
import org.koin.dsl.module.module

val repositoryModules = module {
    single { RemoteDataSource()}

    single{Repository(remoteDataSource = get(REMOTE_DATA_STORE))}
}