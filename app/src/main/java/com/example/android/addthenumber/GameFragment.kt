package com.example.android.addthenumber

import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import com.example.android.addthenumber.databinding.FragmentGameBinding
import java.util.*

class GameFragment : Fragment() {
    private lateinit var binding: FragmentGameBinding

    var ans = 0
    var ansindex = 0
    var correctanstotal = 0
    var total = 0
    var isGameOn = true
    var isQuestion1 = 0
    var isQuestion2 = 0


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate<FragmentGameBinding>(inflater, R.layout.fragment_game, container, false)

        var countDownTimer = object : CountDownTimer(60 * 1000 + 100, 1000)//this
        {
            override fun onTick(millisUntilFinished: Long) {
                val second = millisUntilFinished.toInt() / 1000
                var time = Integer.toString(second)
                binding.timerTextView.text = time
            }

            override fun onFinish() {
                isGameOn = false
                view?.findNavController()?.navigate(R.id.action_gameFragment_to_scoreFragment)
            }
        }.start()

        fun generateQuestion() {
            val r = Random()
            var i = 0
            val i1 = r.nextInt(100) + 1
            val i2 = r.nextInt(100) + 0
            isQuestion1 = i1
            isQuestion2 = i2
            ans = i1 + i2
            ansindex = r.nextInt(4) + 0
            binding.questionTextView.text = "$i1 + $i2"
            val myArray = ArrayList<Int>()
            for (i in 0..3) {
                if (i != ansindex) {
                    var wrongAns = r.nextInt(200) + i1
                    while (wrongAns == ans) {
                        wrongAns = r.nextInt(200) + i1
                    }
                    myArray.add(wrongAns)
                } else if (i == ansindex) {
                    myArray.add(ans)
                }
            }
            binding.button0.text = Integer.toString(myArray[0])
            binding.button1.text = Integer.toString(myArray[1])
            binding.button2.text = Integer.toString(myArray[2])
            binding.button3.text = Integer.toString(myArray[3])
        }
        generateQuestion()

        binding.button0.setOnClickListener {
            if (binding.button0.text.toString() == ans.toString()) {
                correctanstotal++

            }
            total++
            binding.correctTextView.text = "$correctanstotal/$total"
            generateQuestion()
        }
        binding.button1.setOnClickListener {
            if (binding.button1.text.toString() == ans.toString()) {
                correctanstotal++
            }
            total++
            binding.correctTextView.text = "$correctanstotal/$total"
            generateQuestion()

        }
        binding.button2.setOnClickListener {
            if (binding.button2.text.toString() == ans.toString()) {
                correctanstotal++
            }
            total++
            binding.correctTextView.text = "$correctanstotal/$total"
            generateQuestion()

        }
        binding.button3.setOnClickListener {
            if (binding.button3.text.toString() == ans.toString()) {
                correctanstotal++
            }
            total++
            binding.correctTextView.text = "$correctanstotal/$total"
            generateQuestion()


        }

        return binding.root
        }




}

