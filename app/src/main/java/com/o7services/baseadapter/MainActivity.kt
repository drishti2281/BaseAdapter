package com.o7services.baseadapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.o7services.baseadapter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    var array= arrayListOf<String>("drishti","ritika","kiran","radha")
    var baseAdapterClass:BaseAdapterClass= BaseAdapterClass(array)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.Listview.adapter = baseAdapterClass

        binding.Listview.setOnItemClickListener{adapterView,view,position,itemid->
            Toast.makeText(this, "items Clicked $position", Toast.LENGTH_SHORT).show()
            array.set(position,"This is update")
            baseAdapterClass.notifyDataSetChanged()
        }
        binding.Listview.setOnItemLongClickListener { adapterView, view, position, itemid ->
            Toast.makeText(this, "Long Clicked $position", Toast.LENGTH_SHORT).show()
            array.removeAt(position)
            baseAdapterClass.notifyDataSetChanged()
            return@setOnItemLongClickListener true
        }
        binding.fabtn.setOnClickListener {
            array.add("Adapter class Practice")
            baseAdapterClass.notifyDataSetChanged()
        }
    }
}