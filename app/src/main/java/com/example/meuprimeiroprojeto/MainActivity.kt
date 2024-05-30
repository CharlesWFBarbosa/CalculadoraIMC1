package com.example.meuprimeiroprojeto

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Criar uma ID do componete (botao)
        // Recuperar UI componete no arquivo kotlin atraves do findViewById
        // Colocar acao em um botao atraves do setOnClickListener
        //Recuperei a mensagem do usuario edtPeso.text.toString(),
        // e se for para recuperar numeros acrescentar o .toFloat (edtPeso.text.toString.toFloat())
        // SnackBar utilizado para colocar uma mensagem de "erro" no app caso falta digitar alguma informacao



        val edtPeso: EditText = findViewById<TextInputEditText>(R.id.edt_Peso)
        val edtAltura: EditText = findViewById<TextInputEditText>(R.id.edt_Altura)
        val btncalcular: Button = findViewById(R.id.btncalcular)

        btncalcular.setOnClickListener {
            val pesoStr: String = edtPeso.text.toString()
            val alturaStr: String = edtAltura.text.toString()

            if (pesoStr == "" || alturaStr == "")
            // Mostrar mensagem para usuario
            {
                Snackbar.make(
                    edtPeso,
                    "Preencha todos os campos",
                    Snackbar.LENGTH_LONG
                ).show()

            } else {
                val peso = pesoStr.toFloat()
                val altura = alturaStr.toFloat()

                val alturaFinal: Float = altura * altura
                val result = peso / alturaFinal

                val intent = Intent(this, ResultActivity::class.java)
               intent.putExtra(KEY_RESULT_IMC, result)
                startActivity(intent)




            }
        }
    }
}