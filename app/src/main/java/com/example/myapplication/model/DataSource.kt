package com.example.myapplication.model

import io.reactivex.Single

interface DataSource{
    fun getRepoitoriesFromList(): Single<DataClass>
}