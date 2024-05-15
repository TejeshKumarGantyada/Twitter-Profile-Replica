package com.tejesh.profilegtk

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var modalList = ArrayList<modal>()

    var names = arrayOf(
        "i1",
        "i2",
        "i3",
        "i4",
        "i5",
        "i6",
        "i7",
        "i8",
        "i9",
        "i10",
        "i11",
        "i12",
        "i13",
        "i14",
        "i15"
    )

    var images = intArrayOf(
        R.drawable.i1,
        R.drawable.i2,
        R.drawable.i3,
        R.drawable.i4,
        R.drawable.i5,
        R.drawable.i6,
        R.drawable.i7,
        R.drawable.i8,
        R.drawable.i9,
        R.drawable.i10,
        R.drawable.i11,
        R.drawable.i12,
        R.drawable.i14,
        R.drawable.i13,
        R.drawable.i15,
    )



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        for(i in names.indices){
            modalList.add(modal(names[i], images[i]))
        }

        var customAdaptor = CustomAdaptor(modalList,this)
        val grid: GridView = findViewById(R.id.grid_view)

        grid.adapter = customAdaptor



        val insta: ImageView = findViewById(R.id.insta)
        val fb: ImageView = findViewById(R.id.fb)
        val linkedIn: ImageView = findViewById(R.id.linkedIn)
        val twitter: ImageView = findViewById(R.id.twitter)
        val mail: ImageView = findViewById(R.id.mail)


        insta.setOnClickListener{
            val openUrl = Intent(android.content.Intent.ACTION_VIEW)
            openUrl.data= Uri.parse("https://www.instagram.com/tejeshkumar.gantyada/")
            startActivity(openUrl)
        }

        fb.setOnClickListener{
            val openUrl = Intent(android.content.Intent.ACTION_VIEW)
            openUrl.data= Uri.parse("https://www.facebook.com/tejeshkumar.gantyada")
            startActivity(openUrl)
        }

        linkedIn.setOnClickListener{
            val openUrl = Intent(android.content.Intent.ACTION_VIEW)
            openUrl.data= Uri.parse("https://www.linkedin.com/in/tejesh-kumar-gantyada-643711255/")
            startActivity(openUrl)
        }

        twitter.setOnClickListener{
            val openUrl = Intent(android.content.Intent.ACTION_VIEW)
            openUrl.data= Uri.parse("https://twitter.com/TGantyada")
            startActivity(openUrl)
        }

        mail.setOnClickListener{
            val openUrl = Intent(android.content.Intent.ACTION_VIEW)
            openUrl.data= Uri.parse("https://github.com/TejeshKumarGantyada")
            startActivity(openUrl)
        }


    }

    class CustomAdaptor(var itemModel: ArrayList<modal>, var context: Context): BaseAdapter(){

        var layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        override fun getCount(): Int {
            return itemModel.size
        }

        override fun getItem(p0: Int): Any {
            return itemModel[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getView(position: Int, view: View?, viewGroup: ViewGroup?): View {
            var view = view
            if(view == null){
                view = layoutInflater.inflate(R.layout.row_items, viewGroup, false)

            }



            var imageView = view?.findViewById<ImageView>(R.id.imageView)

            imageView?.setImageResource(itemModel[position].img!!)

            return view!!
        }

    }




}