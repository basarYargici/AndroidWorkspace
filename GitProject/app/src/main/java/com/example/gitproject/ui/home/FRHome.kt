package com.example.gitproject.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gitproject.databinding.FragmentHomeBinding
import com.example.gitproject.model.User
import java.util.*


class FRHome : Fragment(), UserListener {

    private lateinit var binding: FragmentHomeBinding
    private val viewModel: UserViewModel by viewModels()
    private val adapter = UserAdapter(this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecyclerView()
        observeViewModel()
        viewModel.getAll()
    }

    private fun setRecyclerView() {
        binding.rvUsers.apply {
            adapter = this@FRHome.adapter
            layoutManager = LinearLayoutManager(context)
        }
    }

    private fun observeViewModel() {
        viewModel.responseData.observe(viewLifecycleOwner, {
            adapter.setList(userList = it)
            adapter.notifyDataSetChanged()
        })
    }

    override fun onUserSelected(user: User) {
        val action = FRHomeDirections.toUserDetailFragment(user.login)
        findNavController().navigate(action)
    }
}