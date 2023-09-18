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
import com.example.a2foodapp.R
import com.example.a2foodapp.ViewModel.MyViewModel
import com.example.a2foodapp.databinding.FragmentTrangMiengBinding


class FreshFragment : Fragment() {

    private lateinit var binding: FragmentTrangMiengBinding

    private lateinit var mAdapter: FoodAdapter

    private lateinit var viewmodel:MyViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTrangMiengBinding.inflate(inflater, container, false)


        binding.rcvTrangmieng.setHasFixedSize(true)
        binding.rcvTrangmieng.layoutManager = LinearLayoutManager(requireContext())

        viewmodel = ViewModelProvider(requireContext() as ViewModelStoreOwner).get(MyViewModel::class.java)
        viewmodel.addtoFresh().observe(requireContext() as LifecycleOwner, Observer {
            mAdapter =FoodAdapter(it)
            binding.rcvTrangmieng.adapter = mAdapter
        })


        //click button next se navigate sang DrinkFragment
        binding.btnNextTrangmieng.setOnClickListener {
            findNavController().navigate(R.id.action_trangMiengFragment_to_hoaDonFragment)
           for(i in mAdapter.list){

               viewmodel.get_data().value?.add(i)
           }
        }
        //click button back se back lai
        binding.btnBackTrangmieng.setOnClickListener {
           activity?.onBackPressed()
        }
        return binding.root
    }



}