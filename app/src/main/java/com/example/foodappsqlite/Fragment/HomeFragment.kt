package com.example.foodappsqlite.Fragment

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.foodappsqlite.MainActivity
import com.example.foodappsqlite.R
import kotlinx.android.synthetic.main.fragment_home.view.*

class HomeFragment : Fragment() {

    private lateinit var root: View

    override fun onStart() {
        super.onStart()
        (activity as MainActivity?)?.setStatusBarColor(resources.getColor(R.color.teal_200))
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        root = inflater.inflate(R.layout.fragment_home, container, false)

        root.tv_1.setOnClickListener {
            findNavController().navigate(R.id.listFragment)
        }
        root.tv_2.setOnClickListener {
            findNavController().navigate(R.id.addFragment)
        }

        root.header_tv.setOnClickListener {
            (activity as MainActivity?)?.open()
            (activity as MainActivity?)?.setStatusBarColor(resources.getColor(R.color.black))
        }

        return root
    }


}