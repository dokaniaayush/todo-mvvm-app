package com.example.todo_mvvm_fragment.ui.add

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.todo_mvvm_fragment.R
import com.example.todo_mvvm_fragment.database.TaskEntry
import com.example.todo_mvvm_fragment.databinding.FragmentAddBinding
import com.example.todo_mvvm_fragment.viewmodel.TaskViewModel

class AddFragment : Fragment() {

    private val viewModel: TaskViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentAddBinding.inflate(inflater, container, false)
        val myAdapter = ArrayAdapter<String>(
            requireActivity(),
            android.R.layout.simple_spinner_dropdown_item,
            resources.getStringArray(R.array.priority)
        )
        binding.apply {
            spinner.adapter = myAdapter
            btnAdd.setOnClickListener{
                if(TextUtils.isEmpty((edtTask.text))){
                    Toast.makeText(requireContext(), "It's Empty!", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
                val titleString = edtTask.text.toString()
                val priority = spinner.selectedItemPosition

                val taskEntry = TaskEntry(
                    0,
                    titleString,
                    priority,
                    System.currentTimeMillis()
                )

                viewModel.insertTask(taskEntry)
                Toast.makeText(requireContext(), "Successfully Added!!", Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_addFragment_to_taskFragment)
            }

        }
        return binding.root
    }
}