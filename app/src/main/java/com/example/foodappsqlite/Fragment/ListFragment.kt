package com.example.foodappsqlite.Fragment

import android.media.Image
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.foodappsqlite.Adapter.MyAdapter
import com.example.foodappsqlite.DB.DbHelper
import com.example.foodappsqlite.MainActivity
import com.example.foodappsqlite.Models.Food_Class
import com.example.foodappsqlite.R
import kotlinx.android.synthetic.main.fragment_list.*
import kotlinx.android.synthetic.main.fragment_list.view.*

class ListFragment : Fragment() {

    private lateinit var root: View

    override fun onStart() {
        super.onStart()
        (activity as MainActivity?)?.setStatusBarColor(resources.getColor(R.color.teal_700))
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?, ): View? {
        root = inflater.inflate(R.layout.fragment_list, container, false)

        root.header_tv3.setOnClickListener {
            findNavController().popBackStack()
        }

        root.rv.adapter =
            MyAdapter(DbHelper(root.context).getAllFood(), object : MyAdapter.My_interface {
                override fun click(image: Int, position: Int, foodClass: Food_Class) {
                    findNavController().navigate(R.id.aboutFragment,
                        bundleOf(
                            "image" to image,
                            "id" to foodClass.food_id,
                            "name" to foodClass.food_name,
                            "recipe" to foodClass.food_recipes,
                            "description" to foodClass.food_description,
                            "position" to position))
                }
            })

        return root
    }


}