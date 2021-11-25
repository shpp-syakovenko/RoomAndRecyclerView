package com.serglife.roomandrecyclerview.presentation.users

import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import com.serglife.roomandrecyclerview.R
import com.serglife.roomandrecyclerview.databinding.FragmentUsersBinding
import com.serglife.roomandrecyclerview.presentation.users.adapter.UsersAdapter
import com.serglife.roomandrecyclerview.utils.AppTouchHelper
import org.koin.androidx.viewmodel.ext.android.viewModel


class UsersFragment : Fragment(), SearchView.OnQueryTextListener {

    private lateinit var binding: FragmentUsersBinding
    private lateinit var adapter: UsersAdapter
    private val vm by viewModel<UsersViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        // Add menu
        setHasOptionsMenu(true)
        return FragmentUsersBinding.inflate(layoutInflater).also { binding = it }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        adapter = UsersAdapter()
        binding.lifecycleOwner = viewLifecycleOwner
        binding.rvUsers.adapter = adapter

        setupSwipeListener()
        setupClickListener()

        vm.users.observe(viewLifecycleOwner, { listUsers ->
            adapter.submitList(listUsers)
        })

        binding.buttonAddUser.setOnClickListener {
            launchAddFragment()
        }

    }

    private fun setupClickListener() {
        adapter.onClickListener = { user ->
            findNavController().navigate(
                UsersFragmentDirections.actionUsersFragmentToEditFragment(
                    user
                )
            )
        }
    }

    // delete user from adapter
    private fun setupSwipeListener() {

        val callback = AppTouchHelper { viewHolder ->
            val user = adapter.currentList[viewHolder.adapterPosition]
            vm.deleteUser(user)
        }

        val itemTouchHelper = ItemTouchHelper(callback)
        itemTouchHelper.attachToRecyclerView(binding.rvUsers)
    }

    private fun launchAddFragment() {
        findNavController().navigate(UsersFragmentDirections.actionUsersFragmentToAddFragment())
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_menu, menu)

        val search = menu.findItem(R.id.menu_search)
        val searchView = search?.actionView as? SearchView
        searchView?.isSubmitButtonEnabled = true
        searchView?.setOnQueryTextListener(this)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_reload) {
            vm.users.observe(viewLifecycleOwner, { users ->
                adapter.submitList(users)
            })
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        searchDatabase(query)
        return true
    }

    override fun onQueryTextChange(query: String?): Boolean {
        searchDatabase(query)
        return true
    }

    private fun searchDatabase(query: String?) {
        query?.let { text ->
            if (text.isBlank()) return
            vm.searchDatabase("%$text%").observe(viewLifecycleOwner, {
                adapter.submitList(it)
            })
        }
    }

}