package com.example.volley

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.volley.databinding.UserItemBinding
import com.example.volley.reqres.User

class UserAdapter(val context: Context, val userList: List<User>) :
    RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    class UserViewHolder(val binding: UserItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = UserItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = userList[position]
        holder.binding.tvId.text = user.id.toString()
        holder.binding.tvFirstName.text = user.first_name
        holder.binding.tvLastName.text = user.last_name
        holder.binding.tvEmail.text = user.email
        Glide.with(holder.itemView.context).load(user.avatar).into(holder.binding.ivAvatar);
    }

    override fun getItemCount(): Int {
        return userList.size
    }
}