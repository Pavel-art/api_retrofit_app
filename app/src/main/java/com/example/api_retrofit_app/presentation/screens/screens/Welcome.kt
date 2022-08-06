package com.example.api_retrofit_app.presentation.screens.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.api_retrofit_app.R
import com.example.api_retrofit_app.databinding.FragmentWelcomeBinding


class Welcome : Fragment() {

    private var _binding: FragmentWelcomeBinding? = null
    private val binding: FragmentWelcomeBinding
        get() = _binding ?: throw RuntimeException("FragmentWelcomeBinding == null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWelcomeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btn.setOnClickListener{
            launchPostListFragment()
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun launchPostListFragment () {
      requireActivity().supportFragmentManager.beginTransaction()
          .replace(R.id.main_layout, PostList.newInstance())
          .addToBackStack(null)
          .commit()
    }


}

