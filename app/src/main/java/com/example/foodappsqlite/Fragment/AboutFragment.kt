package com.example.foodappsqlite.Fragment

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.fragment.findNavController
import com.example.foodappsqlite.MainActivity
import com.example.foodappsqlite.R
import kotlinx.android.synthetic.main.fragment_about.view.*

class AboutFragment : Fragment() {

    private lateinit var root: View

    override fun onStart() {
        super.onStart()
        (activity as MainActivity?)?.setStatusBarColor(resources.getColor(R.color.teal_700))
    }


    @SuppressLint("SetTextI18n")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?, ): View? {
        root = inflater.inflate(R.layout.fragment_about, container, false)

        var press = false

        root.likeImg.setOnClickListener {
            press = if(press){
                (it as ImageView).setImageResource(R.drawable.heart)
                false
            }else{
                (it as ImageView).setImageResource(R.drawable.fille)
                true
            }
        }

        root.back_arrow.setOnClickListener {
            findNavController().popBackStack()
        }

        val image = arguments?.getInt("image", R.drawable.imj1)!!
        val name = arguments?.getString("name", "lol")
        val recipe = arguments?.getString("recipe", "klk")
        val description = arguments?.getString("description", "jll")

        root.myImage.setImageResource(image)
        root.tv_name.text = name
        root.tv_recipe.text = "Recipe\n${recipe}"
        root.tv_description.text = "Description\n ${description}"

        return root
    }


}