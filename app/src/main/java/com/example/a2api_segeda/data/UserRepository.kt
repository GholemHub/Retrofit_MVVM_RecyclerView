package com.example.a2api_segeda.data

import androidx.lifecycle.LiveData

class PhotoRepository(private val userDao: UserDao) {

    val readAllData: LiveData<List<User>> = userDao.readAllData()

    suspend fun addPhotos(photo: User){
        userDao.addUser(photo)
    }

    suspend fun deleteAllPhoto(){
        userDao.deleteAllUsers()
    }
}