package com.example.imc

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_resultado2.*

class ResultadoActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado2)

        val imc = intent.getParcelableExtra<IMC>("value")

        titleDensidadeCorporal.text = imc.nome.toString()
        textViewHeaderDensidadeCorporal.text = imc.calcular()
        textViewResultadoDensidadeCorporal.text = "Seu IMC "+imc.imc.toString()
        textViewPeso.text = "Seu Peso "+imc.peso.toString()+" kg"
        textViewAltura.text = "Sua Altura "+imc.altura.toString()

    }
}
