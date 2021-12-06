package com.example.rickandmorty.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.rickandmorty.databinding.ItemCharacterBinding
import com.example.rickandmorty.model.Character

class CharacterAdapter(val characters: List<Character>) :
    RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {


    inner class CharacterViewHolder(val binding: ItemCharacterBinding) : RecyclerView.ViewHolder(
        binding
            .root
    ) {
        fun bind(character: Character) {
            binding.apply {
                tvName.text = character.name
                ivImage.load(character.image)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        return CharacterViewHolder(
            ItemCharacterBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val character = characters[position]
        holder.bind(character)
    }

    override fun getItemCount(): Int {
        return characters.size
    }
}