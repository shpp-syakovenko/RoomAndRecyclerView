package com.serglife.roomandrecyclerview.presentation.users

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.serglife.roomandrecyclerview.databinding.FragmentUsersBinding
import com.serglife.roomandrecyclerview.presentation.users.adapter.UsersAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel


class UsersFragment : Fragment() {

    private lateinit var binding: FragmentUsersBinding
    private lateinit var adapter: UsersAdapter
    private val viewModel by viewModel<UsersViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        return FragmentUsersBinding.inflate(layoutInflater).also { binding = it }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = UsersAdapter()
        binding.lifecycleOwner = viewLifecycleOwner
        binding.rvUsers.adapter = adapter

        setupSwipeListener(binding.rvUsers)
        setupClickListener()

        viewModel.users.observe(viewLifecycleOwner, { listUsers ->
            adapter.submitList(listUsers)
        })

        binding.buttonAddUser.setOnClickListener {
            launchAddFragment()
        }

    }

    private fun setupClickListener(){
        adapter.onClickListener = {user ->
            findNavController().navigate(UsersFragmentDirections.actionUsersFragmentToEditFragment(user))
        }
    }

    private fun setupSwipeListener(rv: RecyclerView){
        val callback = object : ItemTouchHelper.SimpleCallback(
            0,
        ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT){
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val user = adapter.currentList[viewHolder.adapterPosition]
                viewModel.deleteUser(user)
            }
        }
        val itemTouchHelper = ItemTouchHelper(callback)
        itemTouchHelper.attachToRecyclerView(rv)
    }

    private fun launchAddFragment() {
        findNavController().navigate(UsersFragmentDirections.actionUsersFragmentToAddFragment())
    }

}