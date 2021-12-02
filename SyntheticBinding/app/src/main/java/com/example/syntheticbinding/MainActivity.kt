package com.example.syntheticbinding

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvResult.text = 0.toString()

        btnSum.setOnClickListener {
            val firstNum = etFirstNumber.text.toString().toInt()
            val secondNum = etSecondNumber.text.toString().toInt()
            val result = firstNum + secondNum
            tvResult.text = result.toString()
        }

        btnMultiply.setOnClickListener {
            val firstNum = etFirstNumber.text.toString().toInt()
            val secondNum = etSecondNumber.text.toString().toInt()
            val result = firstNum * secondNum
            tvResult.text = result.toString()
        }
    }
}