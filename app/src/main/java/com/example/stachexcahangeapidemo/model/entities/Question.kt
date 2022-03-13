package com.example.stachexcahangeapidemo.model.entities

/**
 * data class to represent each question
 */
data class Question(
    val answer_count: Int,
    val creation_date: Int,
    val tags: List<String>,
    val title: String,
)
