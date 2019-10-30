package com.example.myapplication.net

import com.example.myapplication.model.DataClass
import io.reactivex.Single
import retrofit2.http.GET

interface NetService{
    @GET fun getRepositories(): Single<DataClass>
}