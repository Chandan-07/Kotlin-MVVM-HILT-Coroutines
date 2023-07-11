package com.example.codewithcb.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.codewithcb.activity.ItemListAdapter.OnContactsItemClickedListener
import com.example.codewithcb.databinding.ActivityMainBinding
import com.example.codewithcb.domain.models.CharacterModel
import com.example.codewithcb.remote.NetworkResults
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharacterActivity : AppCompatActivity(), OnContactsItemClickedListener {
    var service: Intent ? = null
    var startbutton : Button ? = null
    var stopbutton : Button ? = null
    val image: String? = null
    lateinit var listAdapter: ItemListAdapter
    private lateinit var binding: ActivityMainBinding
    private lateinit var mainViewModel: CharacterViewModel
    val itemlist : ArrayList<CharacterModel> = arrayListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        mainViewModel = ViewModelProvider(this)[CharacterViewModel::class.java]
        service = Intent(applicationContext, MyService::class.java)
        listAdapter = ItemListAdapter(itemlist, this)
        binding.rvListItems.layoutManager = LinearLayoutManager(baseContext)
        binding.rvListItems.adapter = listAdapter


        mainViewModel.movieResponse.observe(this) {
            when(it) {
                is NetworkResults.Loading -> {
                   // binding.progressbar.isVisible = true

                }

                is NetworkResults.Failure -> {
                    Toast.makeText(this, it.errorMessage, Toast.LENGTH_SHORT).show()
                    binding.progressbar.isVisible = false
                }

                is  NetworkResults.Success -> {
                    binding.progressbar.isVisible = false
                    Toast.makeText(this, it.data.toString(), Toast.LENGTH_SHORT).show()
                    itemlist.clear()
                    itemlist.addAll(it.data)
                    Log.d("ContactlistAdapter", "onCreate: ${itemlist.size}")
                    listAdapter.notifyDataSetChanged()

                }
            }
        }

    }

    override fun onContactItemsClicked(contactModel: CharacterModel) {
        val intent =  Intent(this, CharacterDetailsActivity::class.java)
        startActivity(intent)
    }

}