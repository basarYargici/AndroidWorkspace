package com.example.gitproject.ui.details

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gitproject.databinding.ItemRepositoryBinding
import com.example.gitproject.model.Repository

class UserDetailAdapter : RecyclerView.Adapter<UserDetailAdapter.RepositoryViewHolder>() {

    var repositoryList = listOf<Repository>()

    inner class RepositoryViewHolder(val binding: ItemRepositoryBinding) : RecyclerView.ViewHolder(
        binding.root
    ) {

        fun bind(position: Int) {
            val repository = repositoryList[position]
            binding.apply {
                tvName.text = repository.name
                tvStars.text = repository.stargazersCount.toString()
                tvForks.text = repository.forks.toString()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryViewHolder {
        return RepositoryViewHolder(
            ItemRepositoryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RepositoryViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return repositoryList.size
    }
}