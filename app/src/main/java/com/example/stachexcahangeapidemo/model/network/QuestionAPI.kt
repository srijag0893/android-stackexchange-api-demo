package com.example.stachexcahangeapidemo.model.network

import com.example.stachexcahangeapidemo.model.entities.QuestionItem
import com.example.stachexcahangeapidemo.model.util.ApplicationConstants
import retrofit2.Call
import retrofit2.http.GET

/**
 * API class for network calls
 */
interface QuestionAPI {

    @GET(ApplicationConstants.QUESTIONS_API_ENDPOINT)
    fun getQuestionItems() : Call<QuestionItem>
}