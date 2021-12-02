package com.example.databinding

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.databinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)


        binding.tvResult.text = 0.toString()

        binding.btnSum.setOnClickListener {
            val firstNum = binding.etFirstNumber.text.toString().toInt()
            val secondNum = binding.etSecondNumber.text.toString().toInt()
            val result = firstNum + secondNum
            binding.tvResult.text = result.toString()
        }

        binding.btnMultiply.setOnClickListener {
            val firstNum = binding.etFirstNumber.text.toString().toInt()
            val secondNum = binding.etSecondNumber.text.toString().toInt()
            val result = firstNum * secondNum
            binding.tvResult.text = result.toString()
        }
    }
}