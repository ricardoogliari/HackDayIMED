package com.estudos.hackdayimed.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BooksViewModel : ViewModel() {

    private var flag = true;
    private val _books = MutableLiveData<List<String>>()

    val books: LiveData<List<String>> = _books

    fun getBooks() {
        if (flag) {
            Log.e("BooksViewModel", "loadBooks")
            flag = false;
            _books.value = arrayListOf(
                "Android: do Básico ao Avançado",
                "Internet das Coisas para Desenvolvedores",
                "Homo Deus"
            )
        }
    }

    override fun onCleared() {
        Log.e("BooksViewModel", "onCleared")
        super.onCleared()
    }

}