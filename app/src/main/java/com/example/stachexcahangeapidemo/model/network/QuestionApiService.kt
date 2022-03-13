package com.example.stachexcahangeapidemo.model.network

import com.example.stachexcahangeapidemo.model.entities.Question
import com.example.stachexcahangeapidemo.model.util.ApplicationConstants
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Api service class for making network calls
 */
class QuestionApiService {

    private val retrofit = Retrofit.Builder()
        .baseUrl(ApplicationConstants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val questionAPI:QuestionAPI = retrofit.create(QuestionAPI::class.java)

    fun getQuestions():Call<List<Question>> {
        return questionAPI.getQuestions()
    }
}