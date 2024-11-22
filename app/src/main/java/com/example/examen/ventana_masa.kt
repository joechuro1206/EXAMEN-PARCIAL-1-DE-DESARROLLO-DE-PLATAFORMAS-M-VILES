package com.example.examen

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ventana_masa : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ventana_masa)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val pesoEditText = findViewById<EditText>(R.id.pesoEditText)
        val alturaEditText = findViewById<EditText>(R.id.alturaEditText2)
        val calcularButton = findViewById<Button>(R.id.calcularButton)
        val resultadoTextView = findViewById<TextView>(R.id.resultadpTextView2)
        val resultadoTextView2 = findViewById<TextView>(R.id.resultado)

        regresar()

        calcularButton.setOnClickListener {
            val alturaStr = alturaEditText.text.toString()
            val pesoStr = pesoEditText.text.toString()
            if (alturaStr.isEmpty()) {
                Toast.makeText(this, "Por favor ingresa tu altura.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (pesoStr.isEmpty()) {
                Toast.makeText(this, "Por favor ingresa tu peso.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val peso = pesoStr.toDouble()
            val altura = alturaStr.toDouble()

            val imc = calcularIMC(peso, altura)
            val estadoIMC = obtenerEstadoIMC(imc)

            resultadoTextView.text = "$imc"
            resultadoTextView2.text = "Estado: $estadoIMC"


        }
    }
    private fun calcularIMC(peso: Double, altura: Double): Double {
        val alturaMetros = altura / 100.0
        return peso / (alturaMetros * alturaMetros)
    }

    private fun obtenerEstadoIMC(imc: Double): String {
        return when {
            imc < 18.5 -> "Bajo peso"
            imc in 18.5..24.9 -> "Normal"
            imc in 25.0..29.9 -> "Sobrepeso"
            else -> "Obesidad"
        }
    }

    fun regresar() {
        val btn = findViewById<Button>(R.id.calcular)
        btn.setOnClickListener {
            val saltar = Intent(this, MainActivity::class.java)

            startActivity(saltar)
        }
    }
}
