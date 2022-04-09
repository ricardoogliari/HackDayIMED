package com.estudos.hackdayimed.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.estudos.hackdayimed.R
import com.estudos.hackdayimed.databinding.FragmentDetailBinding
import com.estudos.hackdayimed.model.Book
import com.squareup.picasso.Picasso

class DetailFragment: Fragment() {

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    companion object {

        const val BOOK_KEY = "BOOK_KEY"

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.detailComprar.setOnClickListener { findNavController().navigate(R.id.action_detailFragment_to_payFragment) }

        val book = arguments?.getParcelable<Book>(BOOK_KEY)
        book?.apply {
            Picasso.get().load(capa).into(binding.detailCapa)

            binding.detailAuthor.text = getString(R.string.autor, autor)
            binding.detailEditora.text = getString(R.string.editora, editora)
            binding.detailResumo.text = resumo
            binding.detailTitulo.text = titulo
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}