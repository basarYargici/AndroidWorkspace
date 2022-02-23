package com.example.travelapp.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.travelapp.base.BaseFragment
import com.example.travelapp.databinding.FragmentDetailBinding

class DetailFragment : BaseFragment<FragmentDetailBinding>() {

    private var attractionId: String? = null

    override fun setViewBinding(inflater: LayoutInflater, container: ViewGroup?) =
        FragmentDetailBinding.inflate(inflater, container, false)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            attractionId = it.getString("attractionId")
        }
    }

    override fun initViews() {
        binding.tvAttractionId.text = attractionId
    }
}