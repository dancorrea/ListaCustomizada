package com.dscorrea.listacustomizada

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_detalhe_equipe.*

class DetalheEquipe : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhe_equipe)

        val intent = intent

        if (intent != null) {
            val equipe = intent.getSerializableExtra("equipe") as Equipe
            val nomeequipe = findViewById<TextView>(R.id.nomeequipe)
         //   val escudo = findViewById<ImageView>(R.id.escudo)
            nomeequipe.text = equipe.nome
            motorequipe.text = equipe.motor
         //   escudo.setImageBitmap(equipe.img)
        }
    }
}
