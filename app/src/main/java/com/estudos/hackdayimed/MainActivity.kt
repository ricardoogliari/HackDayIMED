package com.estudos.hackdayimed

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import com.estudos.hackdayimed.adapter.CustomAdapter
import com.estudos.hackdayimed.databinding.ActivityMainBinding
import com.estudos.hackdayimed.viewmodel.BooksViewModel


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: BooksViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onPostResume() {
        super.onPostResume()
        createObserver()
        viewModel.getBooks()
    }

    private fun createObserver(){
        viewModel.books.observe(this) {
            Log.e("MainActivity", "observer")
            val customAdapter = CustomAdapter(
                it
            )

            binding.mainRecycler.apply {
                adapter = customAdapter
                addItemDecoration(DividerItemDecoration(this.context, DividerItemDecoration.VERTICAL))
            }
        }
    }


}