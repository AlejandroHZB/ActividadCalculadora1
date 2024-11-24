package com.pruebas.actividadcalculadora1

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val salarioBruto = intent.getDoubleExtra("salarioBruto", 0.0)
        val numeroPagas = intent.getIntExtra("numeroPagas", 0)
        val edad = intent.getIntExtra("edad", 0)
        val grupoProfesional = intent.getStringExtra("grupoProfesional") ?: ""
        val gradoDiscapacidad = intent.getDoubleExtra("gradoDiscapacidad", 0.0)
        val estadoCivil = intent.getStringExtra("estadoCivil") ?: ""
        val hijos = intent.getIntExtra("hijos", 0)

        val irpf = salarioBruto * 0.10
        val salarioMensual = salarioBruto/numeroPagas
        val deducciones = (gradoDiscapacidad * 10) + (hijos * 100)
        val salarioNeto = salarioBruto - irpf - deducciones

        val salarioBrutoMensualF = String.format("%.2f", salarioMensual)
        val salarioNetoF = String.format("%.2f", salarioNeto)
        val irpfF = String.format("%.2f", irpf)
        val deduccionesF = String.format("%.2f", deducciones)


        findViewById<TextView>(R.id.salarioBrutoResult).text = "Salario Bruto Mensual : $salarioBrutoMensualF € "
        findViewById<TextView>(R.id.salarioNetoResult).text = "Salario Neto Anual : $salarioNetoF € "
        findViewById<TextView>(R.id.irpfResult).text = "IRPF : $irpfF € "
        findViewById<TextView>(R.id.deduccionesResult).text = "Posibles deducciones : $deduccionesF € "



    }
}