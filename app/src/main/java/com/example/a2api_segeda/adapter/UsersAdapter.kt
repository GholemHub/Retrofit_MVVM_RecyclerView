package com.example.a2api_segeda.adapter


import android.icu.number.NumberFormatter.with
import android.icu.number.NumberRangeFormatter.with
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.a2api_segeda.R
import com.example.a2api_segeda.model.MainRepository.Companion.MainActivityContext
import com.example.a2api_segeda.model.MainRepository.Companion.UserBridge
import com.example.a2api_segeda.model.MainRepository.Companion.bindingFragmentRecyclerView
import com.example.a2api_segeda.model.Post
import com.squareup.picasso.Picasso


class UsersAdapter: RecyclerView.Adapter<UsersAdapter.MyViewHolder>() {


    private var myList = emptyList<Post>()

    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        var name_tv: TextView
        var api_tv: TextView
        var logo_iv: ImageView
        var itemUser: ConstraintLayout


        init {
            name_tv = itemView.findViewById(R.id.name_TV)
            api_tv = itemView.findViewById(R.id.API_TV)
            logo_iv = itemView.findViewById(R.id.logo_IV)
            itemUser = itemView.findViewById(R.id.User)

        }

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false))
    }

    override fun getItemCount(): Int {
        return myList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.itemUser.setOnClickListener {
            UserBridge = myList[position]
            Navigation.findNavController(bindingFragmentRecyclerView.root)
                .navigate(R.id.action_recyclerViewFragment_to_userInfoFragment2)

        }

        holder.name_tv.text = myList[position].login
        holder.api_tv.text = myList[position].id.toString()

        val imageUri = myList[position].avatar_url
        val ivBasicImage = holder.logo_iv

        val picasso = Picasso.get()
        picasso.load(imageUri).into(ivBasicImage)

    }

    fun setData(newList: List<Post>){
        myList = newList
        notifyDataSetChanged()
    }

}