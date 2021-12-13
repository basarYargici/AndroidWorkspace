package com.example.gitproject.ui.Home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gitproject.databinding.ItemUsersBinding
import com.example.gitproject.model.UsersItem

class UsersAdapter : RecyclerView.Adapter<UsersAdapter.UsersViewHolder>() {

    private val usersItem = UsersItem(
        avatar_url = "https://github.com/images/error/octocat_happy.gif",
        id = 1,
        login = "octocat",
        node_id = "MDQ6VXNlcjE=",
        type = "User"
    )


    private val usersItemList = mutableListOf<UsersItem>(
        usersItem
    )

    class UsersViewHolder(val binding: ItemUsersBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(usersItem: UsersItem) {
            binding.apply {
//                ivAvatar.setImageResource(usersItem.avatar_url)
//                ivAvatar.load(usersItem.avatar_url) // picasso
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
        val usersItem = usersItemList[0]
        holder.bind(usersItem)
    }

    override fun getItemCount(): Int {
        return usersItemList.size
    }
}