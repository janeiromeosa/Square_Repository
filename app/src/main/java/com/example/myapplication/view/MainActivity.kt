package com.example.myapplication.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val squareReposViewModel: SquareReposViewModel by viewModel<SquareReposViewModel>()
    private val repositoryAdapter = RepositoryAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv_repository_information.layoutManager = LinearLayoutManager(this)
        rv_repository_information.adapter = repositoryAdapter

        squareReposViewModel.getRepositoryObservable().observe(this, Observer {
            repositoryAdapter.setData(it)

        })
    }


}
