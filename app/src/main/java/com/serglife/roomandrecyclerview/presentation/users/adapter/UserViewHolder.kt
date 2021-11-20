package com.serglife.roomandrecyclerview.presentation.users.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.serglife.roomandrecyclerview.databinding.ItemUserBinding
import com.serglife.roomandrecyclerview.domain.entity.User

class UserViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    private val binding = ItemUserBinding.bind(itemView)
    fun bind(user: User){
        binding.tvId.text = user.id.toString()
        binding.tvName.text = user.name
        binding.tvSecondName.text = user.secondName
        binding.tvAge.text = user.age.toString()
    }
}