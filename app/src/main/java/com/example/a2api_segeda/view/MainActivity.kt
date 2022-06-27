package com.example.a2api_segeda.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Log.d
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.a2api_segeda.data.User
import com.example.a2api_segeda.data.UserViewModel
import com.example.a2api_segeda.viewModel.MainViewModel
import com.example.a2api_segeda.viewModel.MainViewModelFactory
import com.example.a2api_segeda.databinding.ActivityMainBinding
import com.example.a2api_segeda.model.MainRepository
import com.example.a2api_segeda.model.MainRepository.Companion.MainActivityContext
import com.example.a2api_segeda.model.MainRepository.Companion.roomList
import com.example.a2api_segeda.model.Post
import com.example.a2api_segeda.repository.Repository

class MainActivity : AppCompatActivity() {

    lateinit var bindingMainActivity: ActivityMainBinding
    lateinit var listFromDB: List<Post>
    private lateinit var userViewModel: UserViewModel
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        MainActivityContext = this

        bindingMainActivity = ActivityMainBinding.inflate(layoutInflater)
        var view = bindingMainActivity.root

        setContentView(view)

        GetDataFromDB()
        PutDataToRoom()


    }

    private fun PutDataToRoom() {
        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        userViewModel.readAllData.observe(this, Observer {user ->
            roomList = user
        })
    }



    private fun GetDataFromDB() {

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory)
            .get(MainViewModel::class.java)

        viewModel.getPost()

        viewModel.myPosts.observe(MainActivityContext, Observer{response ->
            if(response.isSuccessful) {
                response.body()?.let {
                    listFromDB = it
                    listFromDB.forEach { user -> userViewModel.addUser(User(user.id, user.login, user.avatar_url ))}
                }

            }else{
                d("TAG", response.errorBody().toString())
            }
        })
    }



}