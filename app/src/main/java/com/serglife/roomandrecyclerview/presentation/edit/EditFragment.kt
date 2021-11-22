package com.serglife.roomandrecyclerview.presentation.edit

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.serglife.roomandrecyclerview.R
import com.serglife.roomandrecyclerview.databinding.FragmentEditBinding
import com.serglife.roomandrecyclerview.presentation.add.AddViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.*


class EditFragment : Fragment() {
    private lateinit var binding: FragmentEditBinding
    private val args by navArgs<EditFragmentArgs>()
    private val vm: AddViewModel by viewModel()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        // Add menu
        setHasOptionsMenu(true)
        return FragmentEditBinding.inflate(layoutInflater).also { binding = it }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fillEditField()
        binding.buttonEdit.setOnClickListener {
            editUser()
        }
    }

    private fun fillEditField() {
        binding.nameEdit.setText(args.user.name)
        binding.secondNameEdit.setText(args.user.secondName)
        binding.ageEdit.setText(args.user.age.toString())
    }

    private fun editUser() {
        vm.addUser(
            id = args.user.id,

            name = binding.nameEdit.text.toString().replaceFirstChar {
                if (it.isLowerCase()) it.titlecase(
                    Locale.getDefault()
                ) else it.toString()
            },

            secondName = binding.secondNameEdit.text.toString()
                .replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault())
                else it.toString() },

            age = binding.ageEdit.text.toString().toInt()
        )
        findNavController().navigate(EditFragmentDirections.actionEditFragmentToUsersFragment())
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.delete_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.menu_delete){
            vm.deleteUser(args.user)
            findNavController().navigate(EditFragmentDirections.actionEditFragmentToUsersFragment())
        }
        return super.onOptionsItemSelected(item)
    }

}