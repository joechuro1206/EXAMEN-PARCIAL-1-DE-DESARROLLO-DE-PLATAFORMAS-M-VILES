package com.example.examen

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        navegar()
        navegar2()

    }

    fun navegar() {
        val btn = findViewById<Button>(R.id.btn_peso)
        btn.setOnClickListener {
            val saltar = Intent(this, ventana_peso::class.java)

            startActivity(saltar)
        }
    }

    fun navegar2() {
        val btn = findViewById<Button>(R.id.btn_masa2)
        btn.setOnClickListener {
            val saltar = Intent(this, ventana_masa::class.java)

            startActivity(saltar)
        }
    }
}