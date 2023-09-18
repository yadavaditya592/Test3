package com.example.test3

import android.annotation.SuppressLint
import android.content.Context
import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog

class UserAdapter(
    val context: Context, val userarray: ArrayList<UserData>, val UserClickListener:UserClickInterface):BaseAdapter() {
    override fun getCount(): Int {
        return userarray.size
    }

    override fun getItem(p0: Int): Any {
        return userarray[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    @SuppressLint("MissingInflatedId", "ViewHolder")
    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val layout=LayoutInflater.from(context).inflate(R.layout.list,p2,false)
        val name=layout.findViewById<TextView>(R.id.mTitle)
        val subtitle=layout.findViewById<TextView>(R.id.mSubTitle)
        val Time=layout.findViewById<TextView>(R.id.time)

        name.text=userarray[p0].name
        subtitle.text=userarray[p0].title
        Time.text=userarray[p0].time
        layout.setOnLongClickListener {
//            UserClickListener.onProfileClick(delete, p0)
            val alert=AlertDialog.Builder(context)
            alert.setPositiveButton("Yes",DialogInterface.OnClickListener{dialogInterface, i ->
                    UserClickListener.onProfileClick(userarray[p0].name,p0 )
            })
            val dialog=alert.create()
            dialog.setTitle("Remove")
            dialog.setMessage("Are You Sure")
            dialog.show()
            true
        }




        return layout
    }


//
//    override fun getView(p0: Int, p1: View?, p2: View?): View {
//        val layout = LayoutInflater.from(context).inflate(R.layout.item_list, p2, false)
//        val img = layout.findViewById<ImageView>(R.id.image)
//        val name = layout.findViewById<TextView>(R.id.name)
////        val remove= layout.findViewById<TextView>(R.id.remove)
//        val age = layout.findViewById<TextView>(R.id.age)
//        val remove = layout.findViewById<Button>(R.id.remove)
//
//
//        img.setImageResource(userarray[p0].image)
//        name.text = userarray[p0].name
//        age.text = userarray[p0].age.toString()
//
//        remove.setOnClickListener {
//
//            UserClickListener.onProfileClick(userarray[p0].name, p0)
//
//
//        }
//        img.setOnClickListener {
//            val intent = Intent(context, homeActivity::class.java)
//            intent.putExtra("name", userarray[p0].name)
//            intent.putExtra("gamil", userarray[p0].age)
//            intent.putExtra("pic", userarray[p0].image)
//            context.startActivity(intent)
//        }
//
//        return layout

    }


