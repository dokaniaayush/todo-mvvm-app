package com.example.todo_mvvm_fragment.util

import android.widget.TextView
import android.graphics.Color
import androidx.cardview.widget.CardView
import androidx.databinding.BindingAdapter
import com.example.todo_mvvm_fragment.R
import java.text.DateFormat

@BindingAdapter("setPriority")
fun setPriority(view: TextView, priority: Int){
    when(priority){
        0 -> {
            view.text = "High Priority"
            view.setTextColor(Color.RED)
        }
        1 -> {
            view.text = "Medium Priority"
            view.setTextColor(Color.BLUE)
        }

        2 -> {
            view.text = "Low Priority"
            view.setTextColor(Color.GREEN)
        }
    }
}

@BindingAdapter("setTimeStamp")
fun setTimeStamp(view: TextView, timeStamp: Long){
    view.text = DateFormat.getInstance().format(timeStamp)
}
