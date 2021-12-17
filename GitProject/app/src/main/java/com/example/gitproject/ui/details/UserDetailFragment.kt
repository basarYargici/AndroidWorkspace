package com.example.gitproject.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.gitproject.databinding.FragmentUserDetailBinding
import com.squareup.picasso.Picasso

class UserDetailFragment : Fragment() {

    lateinit var binding: FragmentUserDetailBinding
    lateinit var id: String
    lateinit var nodeId: String
    lateinit var avatarUrl: String
    lateinit var type: String
    lateinit var login: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            it.apply {
                id = getString("id").toString()
                nodeId = getString("nodeId").toString()
                avatarUrl = getString("avatarUrl").toString()
                type = getString("type").toString()
                login = getString("login").toString()
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUserDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            tvId.text = id
            tvLogin.text = login
            tvNodeId.text = nodeId
            tvType.text = type
            Picasso.get().load(avatarUrl).into(ivAvatar)
        }
    }
}