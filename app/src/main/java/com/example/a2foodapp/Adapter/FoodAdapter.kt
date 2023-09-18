package com.example.a2foodapp.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.a2foodapp.Model.FoodData
import com.example.a2foodapp.R

class FoodAdapter( var foodList: List<FoodData>):RecyclerView.Adapter<FoodAdapter.MyViewHolder>() {

    val list =ArrayList<FoodData>()

    inner class MyViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val txt_name:TextView=itemView.findViewById(R.id.txt_name_item)
        val img:ImageView=itemView.findViewById(R.id.img_item)
        val cb_item:CheckBox =itemView.findViewById(R.id.cb_item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_item_layout,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return foodList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentItem = foodList[position]
        holder.img.setImageResource(currentItem.image)
        holder.txt_name.text = currentItem.name

        holder.cb_item.setOnCheckedChangeListener{_, isCheck ->
            if(isCheck) {
                list.add(currentItem)
            }
        }
    }
}