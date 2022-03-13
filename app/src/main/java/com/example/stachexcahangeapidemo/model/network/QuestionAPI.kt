package com.example.stachexcahangeapidemo.model.network

import com.example.stachexcahangeapidemo.model.entities.Question
import com.example.stachexcahangeapidemo.model.util.ApplicationConstants
import retrofit2.Call
import retrofit2.http.GET

/**
 * API class for network calls
 */
interface QuestionAPI {
    @GET(ApplicationConstants.QUESTIONS_API_ENDPOINT)
    fun getQuestions() : Call<List<Question>>
}