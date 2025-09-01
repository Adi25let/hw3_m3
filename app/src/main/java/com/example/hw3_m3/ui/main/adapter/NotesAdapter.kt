package com.example.hw3_m3.ui.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.hw3_m3.data.models.TaskModel
import com.example.hw3_m3.databinding.ItemNotesBinding

class NotesAdapter(val onLongClick: (taskModel: TaskModel) -> Unit,
                   val onClick: (taskModel: TaskModel) -> Unit) :Adapter<NotesAdapter.NotesViewHolder>(){

    private val taskList = arrayListOf<TaskModel>()

    fun addAllData(taskDataList: List<TaskModel>){
        taskList.clear()
        taskList.addAll(taskDataList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NotesViewHolder {
        return NotesViewHolder(ItemNotesBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        )
    }

    override fun getItemCount(): Int {
        return taskList.size
    }

    override fun onBindViewHolder(
        holder: NotesViewHolder,
        position: Int
    ) {
        holder.onBind(taskList[position])

    }


    inner class NotesViewHolder(private val binding: ItemNotesBinding): ViewHolder(binding.root) {

        fun onBind(taskModel: TaskModel){
            binding.tvTitle.text = taskModel.title
            binding.tvDesc.text = taskModel.desc

            itemView.setOnLongClickListener {
                onLongClick(taskModel)
                false
            }

            itemView.setOnClickListener {
                onClick(taskModel)
                onClick
            }
        }
    }
}