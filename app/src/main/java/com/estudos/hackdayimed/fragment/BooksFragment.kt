package com.estudos.hackdayimed.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import com.estudos.hackdayimed.R
import com.estudos.hackdayimed.adapter.CustomAdapter
import com.estudos.hackdayimed.databinding.FragmentBooksBinding
import com.estudos.hackdayimed.viewmodel.BooksViewModel

class BooksFragment: Fragment() {

    private var _binding: FragmentBooksBinding? = null
    private val binding get() = _binding!!

    private val viewModel: BooksViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBooksBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        createObserver()
        viewModel.getBooks()
    }

    private fun createObserver(){
        viewModel.books.observe(viewLifecycleOwner) { it ->
            val customAdapter = CustomAdapter(
                it
            ) { book ->
                val bundle = bundleOf(DetailFragment.BOOK_KEY to book)
                findNavController().navigate(R.id.action_booksFragment_to_detailFragment, bundle)
            }

            binding.mainRecycler.apply {
                adapter = customAdapter
                addItemDecoration(DividerItemDecoration(this.context, DividerItemDecoration.VERTICAL))
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}