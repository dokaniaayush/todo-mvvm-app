package com.example.todo_mvvm_fragment.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface TaskDao {
    @Insert
    suspend fun insert(taskEntry: TaskEntry)

    @Delete
    suspend fun delete(taskEntry: TaskEntry)

    @Update
    suspend fun update(taskEntry: TaskEntry)

    @Query("Delete from task_table")
    suspend fun deleteAll()

    @Query("select * from task_table order by timStamp desc")
    fun getAllTasks() : LiveData<List<TaskEntry>>

    @Query("select * from task_table order by priority asc")
    fun getAllPriorityTasks(): LiveData<List<TaskEntry>>

}