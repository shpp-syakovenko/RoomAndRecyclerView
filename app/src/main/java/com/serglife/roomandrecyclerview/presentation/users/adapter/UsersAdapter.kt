package com.serglife.roomandrecyclerview.presentation.users.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.serglife.roomandrecyclerview.R
import com.serglife.roomandrecyclerview.domain.entity.User

class UsersAdapter : ListAdapter<User, UserViewHolder>(UserItemDiffCallback()) {

    var onClickListener: ((user: User)-> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        )
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(currentList[position], onClickListener)
    }
}