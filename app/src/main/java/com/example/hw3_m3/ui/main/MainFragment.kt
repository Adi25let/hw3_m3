package com.example.hw3_m3.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.hw3_m3.App
import com.example.hw3_m3.R
import com.example.hw3_m3.data.local.Pref
import com.example.hw3_m3.data.models.TaskModel
import com.example.hw3_m3.databinding.FragmentMainBinding
import com.example.hw3_m3.ui.main.adapter.NotesAdapter

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private lateinit var pref: Pref
    private val notesAdapter = NotesAdapter(::onLongClick, ::onClick)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        pref = Pref(requireContext())
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.notesRv.adapter = notesAdapter
        getList()

        binding.btnSave.setOnClickListener {
            findNavController().navigate(R.id.detailFragment)

        }
    }


    private fun getList() {
        val list = App.db.taskDao().getAll()
        notesAdapter.addAllData(list)
    }

    private fun onLongClick(taskModel: TaskModel) {
        App.db.taskDao().deleteTask(taskModel)
        getList()
    }

    private fun onClick(taskModel: TaskModel) {
        val bundle: Bundle = Bundle()
        bundle.putSerializable("key", taskModel)
        findNavController().navigate(R.id.detailFragment,bundle)
    }
}
