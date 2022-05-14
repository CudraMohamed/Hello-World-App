package com.example.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.sql.ClientInfoStatus

class BMICalculatorActivity : AppCompatActivity() {
    lateinit var btnCalculate: Button
    lateinit var etWeight:EditText
    lateinit var etHeight: EditText
    lateinit var tvBmi:TextView
    lateinit var tvStatus: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmicalculator)
        btnCalculate = findViewById(R.id.btnCalculate)
        etWeight = findViewById(R.id.etWeight)
        etHeight = findViewById(R.id.etHeight)
        tvBmi = findViewById(R.id.tvBmi)
        tvStatus = findViewById(R.id.tvStatus)

        btnCalculate.setOnClickListener {
            tvBmi.text=""
            tvStatus.text=""
            val weight = etWeight.text.toString()
            val height = etHeight.text.toString()

            if (weight.isBlank()){
                etWeight.setError("Weight is required")
                return@setOnClickListener
            }
            if (height.isBlank()){
                etHeight.error = "Height is required"
                return@setOnClickListener
            }
            calculateBmi(weight.toDouble(),height.toInt())
        }
    }
    fun calculateBmi(weight: Double,height: Int){
        var heightMetres = height/100.0
        val bmi = weight/(heightMetres*heightMetres)
        tvBmi.text = bmi.toString()

        if(bmi<18.5){
            tvStatus.text="Underweight"
        }
        else if(bmi in 18.6..25.0){
            tvStatus.text="Normal"
        }
        else if (bmi in 25.1..30.0){
            tvStatus.text="Overweight"
        }
        else{
            tvStatus.text="Obese"
        }
    }
}