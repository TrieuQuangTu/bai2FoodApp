package com.example.a2foodapp.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.a2foodapp.Adapter.FoodAdapter
import com.example.a2foodapp.Model.FoodData
import com.example.a2foodapp.R
import com.example.a2foodapp.ViewModel.MyViewModel
import com.example.a2foodapp.databinding.FragmentDrinkBinding
import com.example.a2foodapp.databinding.FragmentFoodBinding


class DrinkFragment : Fragment() {

    private lateinit var binding: FragmentDrinkBinding

    private lateinit var mAdapter: FoodAdapter

    private lateinit var viewModel: MyViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDrinkBinding.inflate(inflater, container, false)


        binding.rcvDrink.setHasFixedSize(true)
        binding.rcvDrink.layoutManager = LinearLayoutManager(requireContext())

        viewModel = ViewModelProvider(requireContext() as ViewModelStoreOwner).get(MyViewModel::class.java)

        viewModel.addtoDrink().observe(requireContext() as LifecycleOwner, Observer {
            mAdapter = FoodAdapter(it)
            binding.rcvDrink.adapter = mAdapter

        })



        //click button next se navigate sang DrinkFragment
        binding.btnNextFood.setOnClickListener {
            findNavController().navigate(R.id.action_drinkFragment_to_trangMiengFragment)
           for( i in mAdapter.list){
               viewModel.get_data().value?.add(i)
           }
        }


        binding.btnBackDrink.setOnClickListener {
           activity?.onBackPressed()
        }
        return binding.root
    }



}