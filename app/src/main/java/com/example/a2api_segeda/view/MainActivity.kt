package com.example.a2api_segeda.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.d
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.a2api_segeda.viewModel.MainViewModel
import com.example.a2api_segeda.viewModel.MainViewModelFactory
import com.example.a2api_segeda.databinding.ActivityMainBinding
import com.example.a2api_segeda.model.MainRepository
import com.example.a2api_segeda.model.MainRepository.Companion.MainActivityContext
import com.example.a2api_segeda.repository.Repository

class MainActivity : AppCompatActivity() {


    lateinit var bindingMainActivity: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        MainActivityContext = this

        bindingMainActivity = ActivityMainBinding.inflate(layoutInflater)
        var view = bindingMainActivity.root
        setContentView(view)



        //d("TAG", "ADAFDSF")


    }


}