package com.example.gitproject.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gitproject.databinding.ItemUsersBinding
import com.example.gitproject.model.UsersItem
import com.example.gitproject.repository.UsersItemRepository
import com.squareup.picasso.Picasso

class UsersAdapter : RecyclerView.Adapter<UsersAdapter.UsersViewHolder>() {

    class UsersViewHolder(private val binding: ItemUsersBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(usersItem: UsersItem) {
            binding.apply {
                Picasso.get().load(usersItem.avatar_url).into(ivAvatar)
                tvId.text = usersItem.id.toString()
                tvLogin.text = usersItem.login
                tvNodeId.text = usersItem.node_id
                tvType.text = usersItem.type
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
        val usersItem = UsersItemRepository.usersItemList[position]
        holder.bind(usersItem)
    }

    override fun getItemCount(): Int {
        return UsersItemRepository.usersItemList.size
    }
}