package com.example.hw3_m3.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.hw3_m3.App
import com.example.hw3_m3.data.models.TaskModel
import com.example.hw3_m3.databinding.FragmentDetailBinding
import java.time.LocalDate

class DetailFragment : Fragment() {

private lateinit var binding: FragmentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val currentDate = LocalDate.now()
        binding.tvDate.text = currentDate.toString()
        val taskModel: TaskModel? = arguments?.getSerializable("key") as TaskModel?
        if (taskModel != null){
            binding.etValue.setText(taskModel.title)
            binding.etDesc.setText(taskModel.desc)
            binding.btnSave.setOnClickListener {
                val model = TaskModel(
                    uid = taskModel.uid,
                    title = binding.etValue.text.toString(),
                    desc = binding.etDesc.text.toString()
                )
                App.db.taskDao().updateTask(model)
                findNavController().navigateUp()
            }
        }else{
            binding.btnSave.setOnClickListener {
                val model = TaskModel(
                    title = binding.etValue.text.toString(),
                    desc = binding.etDesc.text.toString()
                )
                App.db.taskDao().updateTask(model)

                findNavController().navigateUp()
            }
        }
    }
}