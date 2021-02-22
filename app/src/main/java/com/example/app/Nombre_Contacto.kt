package com.example.app
/*
@author﻿ Edgar Ortiz / Jesus Fontana
 */

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView

class Nombre_Contacto : AppCompatActivity(), View.OnClickListener {

    /*Aquí estamos creando las variables, con un valor nulo.
     */
    private var btnatras: ImageView? = null

    /*En esta función daremos el valor a las variables que hemos creado anteriormente.
    * Le indicaremos la id del botón, imagen, etc..
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nombre__contacto)

        btnatras = findViewById<ImageView>(R.id.imageView15)

        btnatras!!.setOnClickListener(this)
    }
    /*En esta función indicaremos lo que hará el botón, imagen, etc. cuando el usuario haga click.
    */
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.imageView15 -> {
                val intent: Intent = Intent(this, Chats::class.java)
                startActivity(intent)
            }
        }
    }
}