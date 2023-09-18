package com.example.a2foodapp.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.a2foodapp.Adapter.FoodAdapter
import com.example.a2foodapp.Model.FoodData
import com.example.a2foodapp.R
import com.example.a2foodapp.ViewModel.MyViewModel
import com.example.a2foodapp.databinding.FragmentHoaDonBinding


class HoaDonFragment : Fragment() {
    private lateinit var binding:FragmentHoaDonBinding
    private lateinit var mAdapter: FoodAdapter

    private lateinit var viewModel: MyViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHoaDonBinding.inflate(inflater,container,false)

        binding.rcvHoadon.setHasFixedSize(true)
        binding.rcvHoadon.layoutManager = LinearLayoutManager(requireContext())

        viewModel = ViewModelProvider(requireContext() as ViewModelStoreOwner).get(MyViewModel::class.java)
        viewModel.get_data().observe(requireContext() as LifecycleOwner, Observer {

            mAdapter = FoodAdapter(it)
            binding.rcvHoadon.adapter = mAdapter
        })

        binding.btnBackHoadon.setOnClickListener {
            activity?.onBackPressed()
        }


        return binding.root
    }
}