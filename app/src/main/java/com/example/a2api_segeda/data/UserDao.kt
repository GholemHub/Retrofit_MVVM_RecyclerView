package com.example.a2api_segeda.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(photo: User)

    @Query("SELECT * FROM User_table")
    fun readAllData(): LiveData<List<User>>

    @Query("DELETE FROM User_table")
    suspend fun deleteAllUsers()




}
