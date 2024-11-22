package com.example.examen

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ventana_peso : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ventana_peso)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val alturaEditText = findViewById<EditText>(R.id.alturaEditText2)
        val generoSpinner = findViewById<Spinner>(R.id.Sexo)
        val calcularButton = findViewById<Button>(R.id.calcular)
        val resultadoTextView = findViewById<TextView>(R.id.resultadpTextView2)
        val resultadoTextView2 = findViewById<TextView>(R.id.resultado)
        val generos = arrayOf("Masculino", "Femenino")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, generos)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        generoSpinner.adapter = adapter

        regresar()

        calcularButton.setOnClickListener {
            val alturaStr = alturaEditText.text.toString()

            if (alturaStr.isEmpty()) {
                Toast.makeText(this, "Por favor ingresa tu altura.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val altura = alturaStr.toDouble()
            val genero = generoSpinner.selectedItem.toString()
            val pesoIdeal = calcularPesoIdeal(altura, genero)

            resultadoTextView.text = "%.2f kg".format(pesoIdeal)
            resultadoTextView2.text = "Tu peso ideal es: %.2f kg".format(pesoIdeal)

        }
    }
    private fun calcularPesoIdeal(altura: Double, genero: String): Double {
        return if (genero == "Masculino") {
            altura - 100
        } else {
            altura - 105
        }
    }

    fun regresar() {
        val btn = findViewById<Button>(R.id.regresar)
        btn.setOnClickListener {
            val saltar = Intent(this, MainActivity::class.java)

            startActivity(saltar)
        }
    }

}