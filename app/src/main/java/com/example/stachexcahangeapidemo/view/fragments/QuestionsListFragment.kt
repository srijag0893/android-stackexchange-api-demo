package com.example.stachexcahangeapidemo.view.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.stachexcahangeapidemo.databinding.FragmentQuestionsListBinding
import com.example.stachexcahangeapidemo.model.entities.Question
import com.example.stachexcahangeapidemo.model.entities.QuestionItem
import com.example.stachexcahangeapidemo.view.adapters.QuestionAdapter
import com.example.stachexcahangeapidemo.viewmodel.QuestionListViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class QuestionsListFragment : Fragment() {
    private lateinit var questionsListViewModel: QuestionListViewModel
    private var _binding: FragmentQuestionsListBinding? = null

    private val questionAdapter: QuestionAdapter = QuestionAdapter()

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        questionsListViewModel =
            ViewModelProvider(this).get(QuestionListViewModel::class.java)
        _binding = FragmentQuestionsListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding?.swipeToRefresh?.setOnRefreshListener { fetchQuestions() }


        fetchQuestions()
    }

    private fun fetchQuestions() {
        val questionDataFetchCallback = object : Callback<QuestionItem> {
            override fun onResponse(call: Call<QuestionItem>, response: Response<QuestionItem>) {
                if (response.isSuccessful) {
                    var questions = response.body()
                    questions?.items?.let {
                        //filtering out question having answers
                        val questionWithAnswers = mutableListOf<Question>()
                        for (question in questions.items) {
                            if (question.answer_count > 0) {
                                questionWithAnswers.add(question)
                            }
                        }
                        questionAdapter.setQuestions(questions.items)
                        _binding?.questionsList?.adapter = questionAdapter
                        _binding?.swipeToRefresh?.isRefreshing = false
                    }
                }
            }

            override fun onFailure(call: Call<QuestionItem>, t: Throwable) {
                Toast.makeText(context, "unable to fetch questions", Toast.LENGTH_SHORT).show()
                _binding?.swipeToRefresh?.isRefreshing = false
            }
        }
        questionsListViewModel.startDownloading(questionDataFetchCallback)
    }
}