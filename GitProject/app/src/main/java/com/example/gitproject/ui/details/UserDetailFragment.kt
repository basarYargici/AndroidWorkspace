package com.example.gitproject.ui.details

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.gitproject.databinding.FragmentUserDetailBinding
import com.example.gitproject.model.Repository
import com.example.gitproject.model.UserDetail
import com.squareup.picasso.Picasso

class UserDetailFragment : Fragment() {

    lateinit var binding: FragmentUserDetailBinding
    private val viewModel: UserDetailViewModel by viewModels()
    var username: String? = null
    var userDetail: UserDetail? = null
    var userRepository: List<Repository>? = mutableListOf<Repository>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            username = it.getString("username").toString()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUserDetailBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getByUsername(username)
        observeLiveData()
        viewModel.getUserRepositories(username)
        setComponent()
    }

    private fun setComponent() {
        binding.apply {
            tvId.text = userDetail?.id?.toString() ?: ""
            tvType.text = userDetail?.type ?: ""
            tvLogin.text = userDetail?.login ?: ""
            tvNodeId.text = userDetail?.nodeId ?: ""
            Picasso.get().load(userDetail?.avatarUrl).into(ivAvatar)
        }
    }

    private fun observeLiveData() {
        viewModel.userDetails.observe(viewLifecycleOwner, {
            userDetail = it
            setComponent()
            Log.e("test", "observeLiveData: " + it.toString())
        })

        viewModel.userRepositories.observe(viewLifecycleOwner, {
            userRepository = it
            Log.e("test", "observeLiveData: " + it.toString())
        })
    }
}