package com.example.foodappsqlite.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.foodappsqlite.DB.DbHelper
import com.example.foodappsqlite.MainActivity
import com.example.foodappsqlite.Models.Food_Class
import com.example.foodappsqlite.R
import kotlinx.android.synthetic.main.fragment_add.*
import kotlinx.android.synthetic.main.fragment_add.view.*

class AddFragment : Fragment() {

    private lateinit var root: View
    private lateinit var dbHelper: DbHelper

    override fun onStart() {
        super.onStart()
        (activity as MainActivity?)?.setStatusBarColor(resources.getColor(R.color.teal_700))
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        root =  inflater.inflate(R.layout.fragment_add, container, false)

        dbHelper = DbHelper(root.context)

        root.header_tv2.setOnClickListener {
            findNavController().popBackStack()
        }

        root.btn_save.setOnClickListener {
            val name = root.food_name.text.toString().trim()
            val recipe = root.food_recipe.text.toString().trim()
            val description = root.food_description.text.toString().trim()

            if (name.isNotEmpty() && recipe.isNotEmpty() && description.isNotEmpty()){

                dbHelper.addFood(Food_Class(name,recipe,description))
                Toast.makeText(context, "Saved !!", Toast.LENGTH_SHORT).show()
                findNavController().popBackStack()

            }else{
                Toast.makeText(context, "Empty !!", Toast.LENGTH_SHORT).show()
            }
        }

        return root
    }


}