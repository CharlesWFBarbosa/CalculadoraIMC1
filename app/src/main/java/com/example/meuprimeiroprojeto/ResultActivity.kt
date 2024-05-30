package com.example.meuprimeiroprojeto

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

const val KEY_RESULT_IMC = "ResultActivity.KEY_IMC"

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)

        val result = intent.getFloatExtra(KEY_RESULT_IMC, 0F)

        val tvResult = findViewById<TextView>(R.id.tv_result)
        val tvClassificacao = findViewById<TextView>(R.id.tv_classificacao)

        tvResult.text = result.toString()


        val classificacao = if (result <= 18.5) {
            "MAGREZA"
        }  else if(result >= 18.5 && result <= 24.9) {
            "NORMAL"
        } else if(result >= 25.0 && result <= 29.9) {
            "SOBREPESO"
        } else if(result <= 30.0 && result <= 39.9) {
            "OBESIDADE"
        } else if(result >= 40.0) {
            "OBESIDADE GRAVE"
        } else {

        }
        tvClassificacao.text = classificacao.toString()

            }
}




