package com.example.foodappsqlite.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.foodappsqlite.Models.Food_Class
import com.example.foodappsqlite.R
import com.example.foodappsqlite.databinding.ItemRvBinding
import kotlin.random.Random

class MyAdapter(private val list: List<Food_Class>, var myInterface: My_interface) :
    RecyclerView.Adapter<MyAdapter.Vh>() {

    var image: Int = R.drawable.imj4

    inner class Vh(var itemRv: ItemRvBinding) : RecyclerView.ViewHolder(itemRv.root) {
        fun onBind(foodClass: Food_Class, position: Int) {
            itemRv.name.text = foodClass.food_name
            setRandom()
            itemRv.image12.setImageResource(image)
            itemRv.cardview1.setOnClickListener {
                myInterface.click(image, position, foodClass)
            }
        }
    }

    private fun setRandom() {
        image = when (Random.nextInt(1, 4)) {
            1 -> {
                R.drawable.imj1
            }
            2 -> {
                R.drawable.imj2
            }
            3 -> {
                R.drawable.imj3
            }
            else -> {
                R.drawable.imj4
            }
        }
    }

    interface My_interface {
        fun click(image: Int, position: Int, foodClass: Food_Class)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemRvBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position], position)
    }

    override fun getItemCount(): Int = list.size
}