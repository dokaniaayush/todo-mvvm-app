package com.example.todo_mvvm_fragment.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.todo_mvvm_fragment.database.TaskEntry
import com.example.todo_mvvm_fragment.repository.TaskRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TaskViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: TaskRepository

    val getAllTasks: LiveData<List<TaskEntry>>
    val getAllPriorityTasks: LiveData<List<TaskEntry>>

    init{
        repository = TaskRepository(application)
        getAllTasks = repository.getAllTasks()
        getAllPriorityTasks = repository.getAllPriorityTasks()
    }

    fun insertTask(taskEntry: TaskEntry){
        viewModelScope.launch(Dispatchers.IO){
            repository.insertTask(taskEntry)

        }
    }

    fun deleteTask(taskEntry: TaskEntry){
        viewModelScope.launch(Dispatchers.IO){
            repository.deleteTask(taskEntry)
        }
    }

    fun updateTask(taskEntry: TaskEntry){
        viewModelScope.launch(Dispatchers.IO){
            repository.updateTask(taskEntry)
        }
    }

    fun deleteAll(){
        viewModelScope.launch(Dispatchers.IO){
            repository.deleteAll()
        }
    }

}