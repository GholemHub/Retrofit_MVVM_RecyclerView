package com.example.a2api_segeda.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.a2api_segeda.R
import com.example.a2api_segeda.adapter.UsersAdapter
import com.example.a2api_segeda.databinding.FragmentRecyclerViewBinding
import com.example.a2api_segeda.model.MainRepository.Companion.MainActivityContext
import com.example.a2api_segeda.model.MainRepository.Companion.bindingFragmentRecyclerView
import com.example.a2api_segeda.repository.Repository
import com.example.a2api_segeda.viewModel.MainViewModel
import com.example.a2api_segeda.viewModel.MainViewModelFactory

class RecyclerViewFragment : Fragment() {


    //private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        bindingFragmentRecyclerView = DataBindingUtil.inflate<FragmentRecyclerViewBinding>(inflater,
            R.layout.fragment_recycler_view, container, false)



        SetupAdapter()

        return bindingFragmentRecyclerView.root
    }

    private fun SetupAdapter() {
        var adapter = UsersAdapter()
        bindingFragmentRecyclerView.RecyclerView.adapter = adapter
        bindingFragmentRecyclerView.RecyclerView.layoutManager = LinearLayoutManager(context)
        adapter.notifyDataSetChanged()

    }
}