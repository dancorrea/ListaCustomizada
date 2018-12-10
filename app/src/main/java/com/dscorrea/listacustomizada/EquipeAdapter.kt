package com.dscorrea.listacustomizada

import android.content.Context
import android.content.res.AssetManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import java.io.IOException
import java.io.InputStream

class EquipeAdapter(context: Context, lista: ArrayList<Equipe>, assetManager: AssetManager) : BaseAdapter() {

    private var listaEquipes: ArrayList<Equipe>
    private var inflator: LayoutInflater
    private var assetManager: AssetManager

    init {
        this.listaEquipes = lista
        this.inflator = LayoutInflater.from(context)
        this.assetManager = assetManager
    }

    override fun getCount(): Int {
        return this.listaEquipes.size
    }

    override fun getItem(position: Int): Any? {
        return this.listaEquipes.get(position)
    }

    override fun getItemId(position: Int): Long {
        return this.listaEquipes.get(position).id;
    }

    private fun getBitmapFromAsset(id: Long): Bitmap {
        val assetManager = this.assetManager
        var istr: InputStream? = null
        try {
            istr = assetManager.open("images/c$id.png")
        } catch (e: IOException) {
            istr = assetManager.open("images/face_error.png")
        }
        return BitmapFactory.decodeStream(istr)
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {
        val equipe = this.listaEquipes.get(position)
        val view = this.inflator.inflate(R.layout.linha, parent, false)
        val bitmapImage = this.getBitmapFromAsset(equipe.id)
        (view.findViewById<TextView>(R.id.nome)).text = equipe.nome
        var imageView = view.findViewById<ImageView>(R.id.escudo)
        imageView.setImageBitmap(bitmapImage)
        return view
    }

}