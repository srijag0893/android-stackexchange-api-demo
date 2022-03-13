package com.example.stachexcahangeapidemo.model.network

import com.example.stachexcahangeapidemo.model.entities.QuestionItem
import com.example.stachexcahangeapidemo.model.util.ApplicationConstants
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**
 * Api service class for making network calls
 */
class QuestionApiService {

    var gson = GsonBuilder()
        .setLenient()
        .create()

    private val retrofit = Retrofit.Builder()
        .baseUrl(ApplicationConstants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    private val questionAPI:QuestionAPI = retrofit.create(QuestionAPI::class.java)

    fun getQuestionItems():Call<QuestionItem> {
        return questionAPI.getQuestionItems()
    }
}