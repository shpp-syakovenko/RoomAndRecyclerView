package com.serglife.roomandrecyclerview.presentation.add

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.serglife.roomandrecyclerview.databinding.FragmentAddBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.*


class AddFragment : Fragment() {

    private val viewModel by viewModel<AddViewModel>()
    private lateinit var binding: FragmentAddBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentAddBinding.inflate(layoutInflater).also { binding = it }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.buttonAdd.setOnClickListener {
            val name = binding.nameAdd.text.toString()
                .replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }

            val secondName = binding.secondNameAdd.text.toString()
                .replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
            val age = binding.ageAdd.text.toString()

            if (isCheckValid(name, secondName, age)) {
                viewModel.addUser(
                    name = name,
                    secondName = secondName,
                    age = age.toInt()
                )
                launchUsersFragment()
            }else{
                Toast.makeText(context,"Fill in all the fields!!!",Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun isCheckValid(name: String, secondName: String, age: String): Boolean {
        return name.isNotEmpty() && secondName.isNotEmpty() && age.isNotEmpty()
    }

    private fun launchUsersFragment() {
        findNavController().navigate(AddFragmentDirections.actionAddFragmentToUsersFragment())
    }
}