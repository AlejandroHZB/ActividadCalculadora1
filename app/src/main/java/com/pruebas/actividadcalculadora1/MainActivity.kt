package com.pruebas.actividadcalculadora1

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton

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

        val salarioBruto = findViewById<EditText>(R.id.sueldoBrutoAnual)
        val numeroPagas = findViewById<EditText>(R.id.numeroPagas)
        val edad = findViewById<EditText>(R.id.edad)
        val grupoProfesional = findViewById<EditText>(R.id.grupoProfesional)
        val gradoDiscapacidad = findViewById<EditText>(R.id.gradoDiscapacidad)
        val estadoCivil = findViewById<EditText>(R.id.estadoCivil)
        val hijos = findViewById<EditText>(R.id.hijos)
        val enviar = findViewById<Button>(R.id.enviar)

        enviar.setOnClickListener{
            val intent = Intent(this,ResultActivity::class.java)
            intent.putExtra("salarioBruto",salarioBruto.text.toString().toDoubleOrNull()?:0.0)
            intent.putExtra("numeroPagas",numeroPagas.text.toString().toIntOrNull()?:0)
            intent.putExtra("edad",edad.text.toString().toIntOrNull()?:0)
            intent.putExtra("grupoPofesional",grupoProfesional.text.toString().toIntOrNull()?:0)
            intent.putExtra("gradoDiscapacidad",gradoDiscapacidad.text.toString().toIntOrNull()?:0)
            intent.putExtra("estadoCivil",estadoCivil.text.toString())
            intent.putExtra("hijos",hijos.text.toString().toIntOrNull()?:0)
            startActivity(intent)
        }


    }
}