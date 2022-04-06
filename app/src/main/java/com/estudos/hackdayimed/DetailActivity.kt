package com.estudos.hackdayimed

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.estudos.hackdayimed.databinding.ActivityDetailBinding
import com.estudos.hackdayimed.model.Book
import com.squareup.picasso.Picasso

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    companion object {

        const val BOOK_KEY = "BOOK_KEY"

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.detailComprar.setOnClickListener { startActivity(Intent(this, PayActivity::class.java)) }

        val book = intent.getParcelableExtra<Book>(BOOK_KEY)
        book?.apply {
            Picasso.get().load(capa).into(binding.detailCapa)

            binding.detailAuthor.text = getString(R.string.autor, autor)
            binding.detailEditora.text = getString(R.string.editora, editora)
            binding.detailResumo.text = resumo
            binding.detailTitulo.text = titulo
        }
    }
}