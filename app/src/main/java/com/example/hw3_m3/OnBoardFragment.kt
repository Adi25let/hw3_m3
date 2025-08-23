package com.example.hw3_m3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.hw3_m3.databinding.FragmentOnBoardBinding
import me.relex.circleindicator.CircleIndicator3


class OnBoardFragment : Fragment() {

    private lateinit var binding: FragmentOnBoardBinding
    private var adapter: OnBoardAdapter = OnBoardAdapter(::onSkip, ::onStart)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOnBoardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewPage.adapter = adapter

        binding.indicator.setViewPager(binding.viewPage)
        adapter.registerAdapterDataObserver(binding.indicator.adapterDataObserver)
    }

    private fun onSkip(){
        binding.viewPage.currentItem++
    }

    private fun onStartBoard(){
        findNavController().navigate(R.id.mainFragment)
    }

}