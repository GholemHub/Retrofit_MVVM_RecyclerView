package com.example.a2api_segeda.model

import androidx.lifecycle.ViewModel
import com.example.a2api_segeda.data.User
import com.example.a2api_segeda.databinding.FragmentRecyclerViewBinding
import com.example.a2api_segeda.databinding.FragmentUserInfoBinding
import com.example.a2api_segeda.view.MainActivity

class MainRepository: ViewModel() {
    companion object{
        var roomList = emptyList<User>()
        lateinit var MainActivityContext: MainActivity
        lateinit var bindingFragmentRecyclerView: FragmentRecyclerViewBinding
        lateinit var bindingFragmentUserInfo: FragmentUserInfoBinding

        lateinit var UserBridge: User
    }
}