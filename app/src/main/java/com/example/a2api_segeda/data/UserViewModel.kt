package com.example.a2api_segeda.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class UserViewModel(application: Application): AndroidViewModel(application) {
    val readAllData: LiveData<List<User>>
    private val repository: PhotoRepository

    init{
        val photoDao = UserDatabase.getDatabase(application).userDao()
        repository = PhotoRepository(photoDao)
        readAllData = repository.readAllData
    }

    fun addUser(photo: User){
        viewModelScope.launch(Dispatchers.IO){
            repository.addPhotos(photo)
        }
    }

    fun deleteAllUsers(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllPhoto()
        }
    }
}