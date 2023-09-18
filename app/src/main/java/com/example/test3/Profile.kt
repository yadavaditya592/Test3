package com.example.test3

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.appcompat.app.AlertDialog
import com.google.android.material.floatingactionbutton.FloatingActionButton

class Profile : Fragment(), UserClickInterface {
    lateinit var  arrayList: ArrayList<UserData>
    lateinit var adapter: UserAdapter


    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val row= inflater.inflate(R.layout.fragment_profile,null, false)
        val add=row.findViewById<FloatingActionButton>(R.id.floating)

        arrayList= ArrayList()


        val list=row.findViewById<ListView>(R.id.list)

        adapter= UserAdapter(requireActivity(),arrayList,this)
        list.adapter=adapter
       add.setOnClickListener {

            showdialog()
        }




        return row
    }

    @SuppressLint("InflateParams", "MissingInflatedId")
    private fun showdialog() {



        val layoutInflater=LayoutInflater.from(context).inflate(R.layout.item_li,null)
        val name=layoutInflater.findViewById<EditText>(R.id.userName)
        val Title=layoutInflater.findViewById<EditText>(R.id.userNo)
        val Timeedit=layoutInflater.findViewById<EditText>(R.id.time_Edit)
        val buttt=layoutInflater.findViewById<Button>(R.id.done)

        val cancel=layoutInflater.findViewById<Button>(R.id.cancel)

        val alert=AlertDialog.Builder(requireActivity())
        val dialog=alert.create()
        dialog.setView(layoutInflater)
        dialog.show()
        buttt.setOnClickListener {
            arrayList.add(UserData(name.text.toString(),Title.text.toString(),Timeedit.text.toString()))
            dialog.dismiss()
            adapter.notifyDataSetChanged()
        }


    }


    override fun onProfileClick(name: String, position: Int) {
        arrayList.removeAt(position)
        adapter.notifyDataSetChanged()
    }


}