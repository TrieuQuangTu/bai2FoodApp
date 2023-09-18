package com.example.a2foodapp.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.viewModelScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.a2foodapp.Adapter.FoodAdapter
import com.example.a2foodapp.Model.FoodData
import com.example.a2foodapp.R
import com.example.a2foodapp.ViewModel.MyViewModel
import com.example.a2foodapp.databinding.FragmentFoodBinding


class FoodFragment : Fragment() {
    private lateinit var binding: FragmentFoodBinding
    private lateinit var viewmodel : MyViewModel
    private lateinit var mAdapter: FoodAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFoodBinding.inflate(inflater, container, false)

        binding.rcvFood.setHasFixedSize(true)
        binding.rcvFood.layoutManager = LinearLayoutManager(requireContext())


        //viewmodel
        viewmodel = ViewModelProvider(requireContext() as ViewModelStoreOwner).get(MyViewModel::class.java)

        viewmodel.addtoFood().observe(requireContext() as LifecycleOwner, Observer {
            mAdapter = FoodAdapter(it)
            binding.rcvFood.adapter = mAdapter
        })


        //click button next se navigate sang DrinkFragment
        binding.btnNextFood.setOnClickListener {
            findNavController().navigate(R.id.action_foodFragment_to_drinkFragment)
            viewmodel.add_data(mAdapter.list)
        }


        return binding.root
    }



}