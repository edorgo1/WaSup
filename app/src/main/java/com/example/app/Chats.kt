package com.example.app
/*
@author Edgar Ortiz / Jesus Fontana
 */

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth

class Chats : AppCompatActivity(), View.OnClickListener {

    /*Aquí estamos creando las variables, con un valor nulo.
     */
    private var btnview1: View? = null
    private var btnview2: View? = null
    private var btntelefono: ImageView? = null
    private var btncontacto: ImageView? = null

    private var cerrarSession: ImageView? = null
    private var nombreusuario: TextView? = null


    /*En esta función daremos el valor a las variables que hemos creado anteriormente.
    * Le indicaremos la id del botón, imagen, etc..
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chats)

        btnview1 = findViewById<View>(R.id.view4);
        btnview2 = findViewById<View>(R.id.view2);
        btntelefono = findViewById<ImageView>(R.id.imageView);
        btncontacto = findViewById<ImageView>(R.id.imageView2);
        cerrarSession = findViewById<ImageView>(R.id.cerrarSession);
        nombreusuario = findViewById<TextView>(R.id.nombreusuario);


        btnview1!!.setOnClickListener(this)
        btnview2!!.setOnClickListener(this)
        btntelefono!!.setOnClickListener(this)
        btncontacto!!.setOnClickListener(this)

        cerrarSession!!.setOnClickListener(this)

        val bundle: Bundle? = intent.extras

        val username: String? = bundle?.getString("username")


        nombreusuario!!.text = username


    }

    /*En esta función indicaremos lo que hará el botón, imagen, etc. cuando el usuario haga click.
    */
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.view4 -> {
                val intent: Intent = Intent(this, Chat::class.java)
                startActivity(intent)
            }
            R.id.view2 -> {
                val intent: Intent = Intent(this, Chat::class.java)
                startActivity(intent)
            }
            R.id.imageView -> {
                val intent: Intent = Intent(this, Llamadas::class.java)
                startActivity(intent)
            }
            R.id.imageView2 -> {
                val intent: Intent = Intent(this, Contactos::class.java)
                startActivity(intent)
            }
            R.id.cerrarSession -> {
                val intent: Intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }

        }

    }
}

    private fun asignarNombre(username: String) {

    }

