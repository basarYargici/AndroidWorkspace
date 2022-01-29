package com.example.recipe

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.recipe.databinding.ActivityMainBinding
import com.example.recipe.network.RecipeService
import com.google.gson.GsonBuilder
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val service = Retrofit.Builder()
            .baseUrl("https://recipesapi.herokuapp.com/api/v2/")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(RecipeService::class.java)

        CoroutineScope(Dispatchers.IO).launch {
            val recipeSearchResponse = service.getRecipeList(query = "chicken", page = 1)
            val recipeResponse = service.getRecipe(recipe_id = 41470)
            Log.d("MainActivity", "onCreate: ${recipeSearchResponse.recipes}")
            Log.d("MainActivity", "onCreate: ${recipeResponse.recipe}")
        }
    }

    override fun onResume() {
        super.onResume()
        val navController = findNavController(binding.navHostFragment.id)
        val appBarConfig = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfig)
    }
}