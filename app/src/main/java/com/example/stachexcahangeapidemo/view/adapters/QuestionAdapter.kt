package com.example.stachexcahangeapidemo.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.stachexcahangeapidemo.R
import com.example.stachexcahangeapidemo.model.entities.Question
import com.example.stachexcahangeapidemo.model.util.DateTimeUtil

class QuestionAdapter : RecyclerView.Adapter<QuestionAdapter.QuestionViewHolder>() {

    private var questions: List<Question>? = null

    fun setQuestions(questions: List<Question>?) {
        this.questions = questions
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.question_item, parent, false)
        return QuestionViewHolder(view)
    }

    override fun onBindViewHolder(holder: QuestionViewHolder, position: Int) {
        val question = questions?.get(position)
        if (question != null) {
            holder.title.text = question.title
            holder.creationTime.text = "created on : " + DateTimeUtil
                .getDateTimeString(question.creation_date)
        }
    }

    override fun getItemCount(): Int {
        return this.questions?.size ?: 0
    }

    class QuestionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.tv_title)
        val creationTime: TextView = itemView.findViewById(R.id.tv_creation_time)
    }
}