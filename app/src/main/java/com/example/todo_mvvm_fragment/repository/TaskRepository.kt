package com.example.todo_mvvm_fragment.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.todo_mvvm_fragment.database.TaskDatabase
import com.example.todo_mvvm_fragment.database.TaskEntry

class TaskRepository(application: Application) {

    private val taskDao = TaskDatabase.getDatabase(application).taskDao()

    suspend fun insertTask(taskEntry: TaskEntry) = taskDao.insert(taskEntry)

    suspend fun deleteTask(taskEntry: TaskEntry) = taskDao.delete(taskEntry)

    suspend fun updateTask(taskEntry: TaskEntry) = taskDao.update(taskEntry)

    suspend fun deleteAll(){ taskDao.deleteAll() }

    fun getAllTasks(): LiveData<List<TaskEntry>> = taskDao.getAllTasks()

    fun getAllPriorityTasks(): LiveData<List<TaskEntry>> = taskDao.getAllPriorityTasks()
}