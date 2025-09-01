package com.example.hw3_m3.ui.onBoard.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hw3_m3.data.models.OnBoardModel
import com.example.hw3_m3.databinding.ItemOnBoardBinding

class OnBoardAdapter(val onSkip: () -> Unit, val onStart:()-> Unit,): RecyclerView.Adapter<OnBoardAdapter.OnBoardViewHolder>() {

    private val OnBoardList = arrayListOf(
        OnBoardModel(
            title = "Удобство",
            desc = "Создавайте заметки в два клика! Записывайте мысли, идеи и важные задачи мгновенно.",
            lottieRes = "lottie_org"
        ),
        OnBoardModel(
            title = "Организация",
            desc = "Организуйте заметки по папкам и тегам. Легко находите нужную информацию в любое время.",
            lottieRes = "lottie_work"
        ),
        OnBoardModel(
            title = "Синхронизация",
            desc = "Синхронизация на всех устройствах. Доступ к записям в любое время и в любом месте.",
            lottieRes = "lottie_org"
        ),
    )

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): OnBoardViewHolder {
        return OnBoardViewHolder(
            ItemOnBoardBinding.inflate(
                LayoutInflater.from(parent.context),parent,false
           )
        )
    }

    override fun onBindViewHolder(
        holder: OnBoardViewHolder,
        position: Int
    ) {
        holder.OnBind(OnBoardList[position])
    }

    override fun getItemCount(): Int {
        return OnBoardList.size
    }

    inner   class OnBoardViewHolder(private val binding: ItemOnBoardBinding): RecyclerView.ViewHolder(binding.root) {
        fun OnBind(model: OnBoardModel) {
            binding.tvTitle.text = model.title
            binding.tvDesc.text = model.desc

            if (adapterPosition ==2){
                binding.btnSkip.visibility = View.INVISIBLE
                binding.btnStart.setOnClickListener {
                    onStart()
                }
            }else{
                binding.btnStart.visibility = View.INVISIBLE
                binding.btnSkip.setOnClickListener {
                    onSkip()
                }
            }

        }

    }
}