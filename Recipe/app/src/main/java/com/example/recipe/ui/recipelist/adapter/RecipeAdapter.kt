package com.example.recipe.ui.recipelist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recipe.R
import com.example.recipe.databinding.ItemRecipeBinding
import com.example.recipe.domain.model.RecipeDetail
import com.example.recipe.ui.recipelist.adapter.RecipeAdapter.RecipeViewHolder
import com.squareup.picasso.Picasso

class RecipeAdapter(
    private var dataSet: List<RecipeDetail>?
) : RecyclerView.Adapter<RecipeViewHolder>() {

    fun setData(list: List<RecipeDetail>) {
        dataSet = list
        notifyDataSetChanged()
    }

    inner class RecipeViewHolder(val binding: ItemRecipeBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private val picassoInstance: Picasso = Picasso.get()
        fun bind(position: Int) {
            val recipe = dataSet?.get(position)
            binding.apply {
                tvTitle.text = recipe?.title
                tvPublishedId.text = recipe?.publishedId
                tvPublisher.text = recipe?.publisher
                picassoInstance
                    .load(recipe?.imageUrl)
                    .placeholder(R.drawable.ic_baseline_arrow_circle_down_24)
                    .error(R.drawable.ic_baseline_error_24)
                    .into(ivImage);
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        return RecipeViewHolder(
            ItemRecipeBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) = holder.bind(position)

    override fun getItemCount() = dataSet?.size ?: 0
}