package com.example.api_retrofit_app.presentation.screens.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.api_retrofit_app.databinding.FragmentPostListBinding
import com.example.api_retrofit_app.models.ItemModelList
import com.example.api_retrofit_app.presentation.screens.adapters.AdapterList
import com.example.api_retrofit_app.presentation.screens.viewmodels.ListViewModel


class PostList : Fragment() {

    private  var _binding: FragmentPostListBinding? =null
    private  val binding: FragmentPostListBinding
        get() = _binding ?: throw RuntimeException("FragmentPostListBinding == null")

 private var listPhoto: ItemModelList? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPostListBinding.inflate(inflater,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = AdapterList()
        binding.rvList.adapter = adapter

        val viewModel = ViewModelProvider(this)[ListViewModel::class.java]
        viewModel.getList()
        viewModel.liveDataList.observe(viewLifecycleOwner){
              adapter.submitList(it.body())
        }
    }



//    private fun setupRecycler (list:com.example.api_retrofit_app.models.ItemModelList) {
//        val adapter = com.example.api_retrofit_app.presentation.screens.adapters.AdapterList()
//        binding.rvList.adapter = adapter
//        adapter.submitList(list)
//    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding =null
    }

    companion object {
         fun newInstance(): PostList {
            return  PostList()
        }
    }

}