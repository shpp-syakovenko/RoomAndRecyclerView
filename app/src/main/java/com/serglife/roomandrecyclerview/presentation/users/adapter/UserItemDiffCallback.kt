package com.serglife.roomandrecyclerview.presentation.users.adapter

import androidx.recyclerview.widget.DiffUtil
import com.serglife.roomandrecyclerview.domain.entity.User

class UserItemDiffCallback : DiffUtil.ItemCallback<User>() {
    override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
       return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem.id == newItem.id
                && oldItem.name == newItem.name
                && oldItem.secondName == newItem.secondName
                && oldItem.age == newItem.age
    }
}