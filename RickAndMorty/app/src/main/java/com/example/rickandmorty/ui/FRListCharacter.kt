package com.example.rickandmorty.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rickandmorty.databinding.FrListCharacterBinding
import com.example.rickandmorty.model.Character
import com.example.rickandmorty.model.CharacterResponse
import com.example.rickandmorty.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FRListCharacter : Fragment() {

    val TAG = "FRListCharacter"
    var res: Call<CharacterResponse>? = null
    private lateinit var binding: FrListCharacterBinding
    private lateinit var characterList: List<Character>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FrListCharacterBinding.inflate(layoutInflater)
        characterList = listOf()
        getAll()

        binding.rvCharacters.apply {
            adapter = CharacterAdapter(characterList)
            layoutManager = GridLayoutManager(context,2)
        }


        return binding.root
    }

    fun getAll() {

        val client = ApiClient.apiService.getAll("3")

        client.enqueue(object : Callback<CharacterResponse> {
            override fun onResponse(call: Call<CharacterResponse>, response: Response<CharacterResponse>) {
                characterList = response.body()!!.characters
                Log.e(TAG, "onResponse: " + response.body())
                binding.rvCharacters.adapter = CharacterAdapter(characterList)
            }

            override fun onFailure(call: Call<CharacterResponse>, err: Throwable) {
                Log.e(TAG, "onResponse: " + err.message)
            }

        })

    }
}