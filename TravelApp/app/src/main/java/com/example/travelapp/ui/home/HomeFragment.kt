package com.example.travelapp.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.travelapp.base.BaseFragment
import com.example.travelapp.databinding.FragmentHomeBinding

class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    override fun initViews() {
        binding.btnNavigate.setOnClickListener {
            val action = HomeFragmentDirections.toDetailFragment("id = 243234")
            findNavController().navigate(action)
        }
    }

    override fun setViewBinding(inflater: LayoutInflater, container: ViewGroup?) =
        FragmentHomeBinding.inflate(inflater, container, false)
}