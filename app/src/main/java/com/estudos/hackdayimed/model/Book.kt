package com.estudos.hackdayimed.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Book (
    val capa: String,
    val titulo: String,
    val autor: String,
    val resumo: String,
    val editora: String
): Parcelable