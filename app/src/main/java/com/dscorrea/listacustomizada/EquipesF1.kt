package com.dscorrea.listacustomizada

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_equipes_f1.*

class EquipesF1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_equipes_f1)

        val listaEquipes = ArrayList<Equipe>()
        val e01 = Equipe(1L, "Scuderia Ferrari", "Ferrari")
        val e02 = Equipe(2L, "Haas F1 Team", "Ferrari")
        val e03 = Equipe(3L, "McLaren F1 Team", "Renault")
        val e04 = Equipe(4L, "Mercedes-AMG Petronas Motorsport", "Mercedes")
        val e05 = Equipe(5L, "Racing Point F1 Team", "Mercedes")
        val e06 = Equipe(6L, "Aston Martin Red Bull Racing", "Honda")
        val e07 = Equipe(7L, "Renault F1 Team", "Renault")
        val e08 = Equipe(8L, "Alfa Romeo Sauber F1 Team", "Ferrari")
        val e09 = Equipe(9L, "Red Bull Toro Rosso Honda", "Honda")
        val e10 = Equipe(10L, "Williams Grand Prix Engineering", "Mercedes")

        listaEquipes.add(e04)
        listaEquipes.add(e01)
        listaEquipes.add(e06)
        listaEquipes.add(e07)
        listaEquipes.add(e02)
        listaEquipes.add(e03)
        listaEquipes.add(e05)
        listaEquipes.add(e08)
        listaEquipes.add(e09)
        listaEquipes.add(e10)

        val adapter = EquipeAdapter(applicationContext, listaEquipes, assets )
        var lista = lista_equipes
        lista.adapter = adapter

//        lista.setOnItemClickListener {parent, view, position, id ->
//            val (id, nome, motor, imagem) = listaEquipes.get(position)
//            Toast.makeText(this, "Clicado : $nome", Toast.LENGTH_SHORT).show()
//        }

        lista.setOnItemClickListener {parent, view, position, id ->
            val equipe = listaEquipes.get(position)
            val intent = Intent(this, DetalheEquipe::class.java)
            intent.putExtra("equipe", equipe)
            startActivity(intent)
        }

    }
}
