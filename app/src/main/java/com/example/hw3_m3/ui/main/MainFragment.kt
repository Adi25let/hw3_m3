package com.example.hw3_m3.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.hw3_m3.data.local.Pref
import com.example.hw3_m3.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private lateinit var pref: Pref


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater,container,false)
        pref = Pref(requireContext())
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val savedValue = pref.getValue()
        binding.tvCounter.text = savedValue.toString()
        binding.etValue.setText(savedValue.toString())

        binding.tvCounter.text = pref.getValue()

        binding.btnSave.setOnClickListener {
            pref.saveValue(binding.etValue.text.toString())
            var textValue =  pref.getValue()
            binding.tvCounter.text = textValue
        }
    }
}