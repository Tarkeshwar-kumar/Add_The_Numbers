package com.example.android.addthenumber

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.android.addthenumber.databinding.FragmentScoreBinding

/**
 * A simple [Fragment] subclass.
 */
class scoreFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var binding = DataBindingUtil.inflate<FragmentScoreBinding>(inflater, R.layout.fragment_score, container, false)
        binding.playAgainButton.setOnClickListener {
            view: View->
            view.findNavController().navigate(R.id.action_scoreFragment_to_titleFragment)
        }

        return binding.root
    }

}
