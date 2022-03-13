package com.example.stachexcahangeapidemo.viewmodel

import androidx.lifecycle.ViewModel
import com.example.stachexcahangeapidemo.model.entities.QuestionItem
import com.example.stachexcahangeapidemo.model.network.QuestionApiService
import retrofit2.Callback

class QuestionListViewModel : ViewModel() {

    fun startDownloading(questionDataFetchCallback:Callback<QuestionItem>) {
        val questionApiService = QuestionApiService()
        questionApiService.getQuestionItems().enqueue(questionDataFetchCallback)
    }
}