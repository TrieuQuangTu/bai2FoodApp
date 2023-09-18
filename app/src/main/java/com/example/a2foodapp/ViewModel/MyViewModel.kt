package com.example.a2foodapp.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.a2foodapp.Model.FoodData
import com.example.a2foodapp.R

class MyViewModel:ViewModel() {

    private val data : MutableLiveData<ArrayList<FoodData>> = MutableLiveData()
    private val livedata : MutableLiveData<ArrayList<FoodData>> = MutableLiveData()


    fun addtoFood() : MutableLiveData<ArrayList<FoodData>>

    {
        val list: ArrayList<FoodData> = ArrayList()
        list.add(FoodData(R.drawable.pizza1, "FOOD",  false))
        list.add(FoodData(R.drawable.pizza1, "FOOD",  false))
        list.add(FoodData(R.drawable.pizza1, "FOOD",  false))
        list.add(FoodData(R.drawable.pizza1, "FOOD",  false))
        list.add(FoodData(R.drawable.pizza1, "FOOD",  false))
        data.postValue(list)
        return data
    }

    fun addtoDrink():MutableLiveData<ArrayList<FoodData>>{

        val list: ArrayList<FoodData> = ArrayList()
        list.add(FoodData(R.drawable.tra_sua1, "Tra sua",  false))
        list.add(FoodData(R.drawable.tra_sua1, "Tra sua",  false))
        list.add(FoodData(R.drawable.tra_sua1, "Tra sua",  false))
        list.add(FoodData(R.drawable.tra_sua1, "Tra sua",  false))
        list.add(FoodData(R.drawable.tra_sua1, "Tra sua",  false))
        data.postValue(list)
        return data
    }

    fun addtoFresh():MutableLiveData<ArrayList<FoodData>>{

        val list: ArrayList<FoodData> = ArrayList()
        list.add(FoodData(R.drawable.trang_mieng3, "Trai cay",false))
        list.add(FoodData(R.drawable.trang_mieng3, "Trai cay",false))
        list.add(FoodData(R.drawable.trang_mieng3, "Trai cay",false))
        list.add(FoodData(R.drawable.trang_mieng3, "Trai cay",false))
        list.add(FoodData(R.drawable.trang_mieng3, "Trai cay",false))
        data.postValue(list)
        return data
    }

    fun add_data(mList: ArrayList<FoodData>){
        livedata.postValue(mList)
    }

    fun get_data():MutableLiveData<ArrayList<FoodData>>{

        return livedata
    }

}