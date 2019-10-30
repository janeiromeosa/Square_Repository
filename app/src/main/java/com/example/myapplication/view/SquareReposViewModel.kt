package com.example.myapplication.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.common.BaseViewModel
import com.example.myapplication.common.addTo
import com.example.myapplication.model.DataClass
import com.example.myapplication.model.Repository
import com.example.myapplication.net.RemoteDataSource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class SquareReposViewModel(val repository: Repository) : BaseViewModel() {

    private val loadingLiveData = MutableLiveData<Boolean>()
    private val contentLiveData: MutableLiveData<DataClass> = MutableLiveData()
//    private lateinit var repository: Repository

    fun getRepositoryObservable(): LiveData<DataClass> = contentLiveData

    fun getObserableBoolean(): LiveData<Boolean> = loadingLiveData

//    fun getSquareRepo(){
//        repository = Repository(remoteDataSource = RemoteDataSource())
//    }

    fun getRepos(){
        repository.getRepoitoriesFromList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {loadingLiveData.value = true }
            .doOnEvent{_, _ -> loadingLiveData.value = false}
            .subscribe({contentLiveData.value = it}, {it.printStackTrace()})
            .addTo(compositeDisposable)
    }
}