package com.example.gitproject.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gitproject.databinding.ItemUsersBinding
import com.example.gitproject.model.User
import com.squareup.picasso.Picasso

class UserAdapter(val userListener: UserListener) : RecyclerView.Adapter<UserAdapter.UsersViewHolder>() {

    var userList = listOf<User>()

    inner class UsersViewHolder(val binding: ItemUsersBinding) : RecyclerView.ViewHolder(
        binding.root
    ) {
        fun bind(position: Int) {
            val user = userList[position]
            binding.apply {
                Picasso.get().load(user.avatarUrl).into(ivAvatar)
                tvId.text = user.id.toString()
                tvLogin.text = user.login
                tvNodeId.text = user.nodeId
                tvType.text = user.type
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersViewHolder {
        return UsersViewHolder(
            ItemUsersBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: UsersViewHolder, position: Int) {
        holder.bind(position)

        holder.binding.mcv.setOnClickListener {
            val user = userList[position]
            userListener.onUserSelected(user)
        }
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    fun setList(userList: List<User>) {
        this.userList = userList
    }
}