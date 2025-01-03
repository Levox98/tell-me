package com.tellme.core_domain.entity

import java.util.Date

data class Note(
    val id: Int,
    val date: Date,
    val title: String,
    val text: String,
)