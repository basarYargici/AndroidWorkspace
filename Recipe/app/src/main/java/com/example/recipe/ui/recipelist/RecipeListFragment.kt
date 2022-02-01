package com.example.recipe.ui.recipelist

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.recipe.R
import com.example.recipe.databinding.FragmentRecipeListBinding
import com.example.recipe.domain.model.Recipe
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecipeListFragment : Fragment() {
    lateinit var binding: FragmentRecipeListBinding
    val viewModel: RecipeListViewModel by viewModels()
    var recipes: List<Recipe>? = null

    // When requested, this adapter returns a DemoObjectFragment,
    // representing an object in the collection.
    private lateinit var demoCollectionAdapter: DemoCollectionAdapter
    private lateinit var viewPager: ViewPager2

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRecipeListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        demoCollectionAdapter = DemoCollectionAdapter(this)
        viewPager = binding.viewPager
        viewPager.adapter = demoCollectionAdapter

        val tabLayout = binding.tabLayout
        val viewPager = binding.viewPager
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = "OBJECT ${(position + 1)}"
        }.attach()

//        viewModel.getRecipeList("chicken", 1)
//        observeLiveData()
    }

    private fun observeLiveData() {
        viewModel.recipes.observe(viewLifecycleOwner, {
            recipes = it
            Log.d("test", "observeLiveData: " + it.toString())
        })
    }
}


class DemoCollectionAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 5

    override fun createFragment(position: Int): Fragment {
        // Return a NEW fragment instance in createFragment(int)
        val fragment = DemoObjectFragment()
        fragment.arguments = Bundle().apply {
            // Our object is just an integer :-P
            putInt(ARG_OBJECT, position + 1)
        }
        return fragment
    }
}

private const val ARG_OBJECT = "object"

// Instances of this class are fragments representing a single
// object in our collection.
class DemoObjectFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_collection_object, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val textView: TextView = view.findViewById(R.id.text1)

        arguments?.takeIf { it.containsKey(ARG_OBJECT) }?.apply {
            textView.text = getInt(ARG_OBJECT).toString()
        }
    }
}
