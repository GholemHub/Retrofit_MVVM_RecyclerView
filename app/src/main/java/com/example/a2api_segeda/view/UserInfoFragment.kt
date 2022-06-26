package com.example.a2api_segeda.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.a2api_segeda.R
import com.example.a2api_segeda.databinding.FragmentRecyclerViewBinding
import com.example.a2api_segeda.databinding.FragmentUserInfoBinding
import com.example.a2api_segeda.model.MainRepository
import com.example.a2api_segeda.model.MainRepository.Companion.UserBridge
import com.example.a2api_segeda.model.MainRepository.Companion.bindingFragmentUserInfo
import com.squareup.picasso.Picasso

class UserInfoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        bindingFragmentUserInfo = DataBindingUtil.inflate<FragmentUserInfoBinding>(inflater,
            R.layout.fragment_user_info, container, false)


        bindingFragmentUserInfo.infoNameTV.text = UserBridge.login
        bindingFragmentUserInfo.infoAPITV.text = UserBridge.id.toString()

        val imageUri = UserBridge.avatar_url
        val ivBasicImage = bindingFragmentUserInfo.infoLogoIV

        val picasso = Picasso.get()
        picasso.load(imageUri).into(ivBasicImage)



        return bindingFragmentUserInfo.root
    }

}