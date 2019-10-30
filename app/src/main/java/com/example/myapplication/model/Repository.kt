package com.example.myapplication.model

import com.example.myapplication.net.RemoteDataSource
import io.reactivex.Single

class Repository(private val remoteDataSource: RemoteDataSource): DataSource {

    override fun getRepoitoriesFromList(): Single<DataClass> {
        return remoteDataSource.getRepoitoriesFromList()
    }
}