package com.example.hw3_m3.ui.onBoard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.example.hw3_m3.R
import com.example.hw3_m3.data.local.Pref
import com.example.hw3_m3.databinding.FragmentOnBoardBinding
import com.example.hw3_m3.ui.onBoard.adapter.OnBoardAdapter


class OnBoardFragment : Fragment() {

    private lateinit var binding: FragmentOnBoardBinding
    private var adapter: OnBoardAdapter = OnBoardAdapter(::onSkip, ::onStart)
    private lateinit var pref: Pref



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOnBoardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        pref = Pref(requireContext())

        adapter = OnBoardAdapter(
            onSkip = { binding.viewPage.currentItem++ },
            onStart = { onStartBoard() }
        )


        binding.viewPage.adapter = adapter
        binding.indicator.setViewPager(binding.viewPage)
        adapter.registerAdapterDataObserver(binding.indicator.adapterDataObserver)

    }

    private fun navigateToMain(){
        findNavController().navigate(
            R.id.mainFragment,null,
            NavOptions.Builder().setPopUpTo(R.id.onBoardFragment,true).build())
    }

    private fun onSkip(){
        binding.viewPage.currentItem++
    }

    private fun onStartBoard(){
        val pref = Pref(requireContext())
        pref.setOnBoardShown()
        findNavController().navigate(R.id.mainFragment,null, NavOptions.Builder().setPopUpTo(R.id.onBoardFragment,true).build()
        )
    }
}