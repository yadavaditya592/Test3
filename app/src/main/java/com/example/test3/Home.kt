package com.example.test3

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class Home : Fragment() {

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val  row= inflater.inflate(R.layout.fragment_home, container, false)

        val list=row.findViewById<ListView>(R.id.listhome)
        val arry= arrayOf("sanjay","akash,","Aditya")
        val adapter=ArrayAdapter(requireActivity(), com.google.android.material.R.layout.support_simple_spinner_dropdown_item,arry)
        list.adapter=adapter


        return row
    }


}