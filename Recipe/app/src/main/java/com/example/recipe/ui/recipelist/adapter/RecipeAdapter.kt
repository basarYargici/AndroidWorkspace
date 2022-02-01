package com.example.recipe.ui.recipelist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recipe.databinding.ItemRecipeBinding
import com.example.recipe.domain.model.Recipe
import com.example.recipe.ui.recipelist.adapter.RecipeAdapter.RecipeViewHolder

class RecipeAdapter(
    private val dataSet: List<Recipe>?
) : RecyclerView.Adapter<RecipeViewHolder>() {

    inner class RecipeViewHolder(val binding: ItemRecipeBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(position: Int) {
            val recipe = dataSet?.get(position)
            binding.apply {
                tvTitle.text = recipe?.title
                tvPublishedId.text = recipe?.publishedId
                tvPublisher.text = recipe?.publisher
//                ivImage.setImageDrawable(recipe.imageUrl)
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