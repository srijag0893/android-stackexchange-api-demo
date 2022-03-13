package com.example.stachexcahangeapidemo.model.util

/**
 * class which is consisting of Application constants used in the application
 */
class ApplicationConstants {
    companion object {
        const val BASE_URL = "https://api.stackexchange.com/docs/"
        const val QUESTIONS_API_ENDPOINT =
            "questions#order=desc&sort=activity&filter=default&site=stackoverflow"
    }
}