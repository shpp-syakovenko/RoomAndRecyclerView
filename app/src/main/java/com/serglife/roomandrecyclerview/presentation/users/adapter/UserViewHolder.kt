package com.serglife.roomandrecyclerview.presentation.users.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.serglife.roomandrecyclerview.databinding.ItemUserBinding
import com.serglife.roomandrecyclerview.domain.entity.User
import org.koin.core.parameter.parametersOf

class UserViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    private val binding = ItemUserBinding.bind(itemView)
    fun bind(user: User, onClick: ((user:User)->Unit)?){
        val pos = adapterPosition + 1
        binding.tvId.text = pos.toString()
        binding.tvName.text = user.name
        binding.tvSecondName.text = user.secondName
        binding.tvAge.text = user.age.toString()
        binding.tvStreet.text = user.address.street
        binding.root.setOnClickListener {
            onClick?.invoke(user)
        }
    }
}