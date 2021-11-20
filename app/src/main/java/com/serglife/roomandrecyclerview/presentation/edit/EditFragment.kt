package com.serglife.roomandrecyclerview.presentation.edit

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.serglife.roomandrecyclerview.databinding.FragmentEditBinding


class EditFragment : Fragment() {
    private lateinit var binding: FragmentEditBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        return FragmentEditBinding.inflate(layoutInflater).also{binding = it}.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

}