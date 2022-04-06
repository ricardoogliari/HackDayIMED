package com.estudos.hackdayimed

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import com.estudos.hackdayimed.adapter.CustomAdapter
import com.estudos.hackdayimed.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val customAdapter = CustomAdapter(
            arrayOf("Android: do Básico ao Avançado", "Internet das Coisas para Desenvolvedores", "Homo Deus")
        )

        binding.mainRecycler.apply {
            adapter = customAdapter
            addItemDecoration(DividerItemDecoration(this.context, DividerItemDecoration.VERTICAL))
        }
    }
}