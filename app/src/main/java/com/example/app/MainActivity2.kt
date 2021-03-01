package com.example.app
/*@author Edgar Ortiz / Jesus Fontana
 */

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore


class MainActivity2 : AppCompatActivity(), View.OnClickListener {

    /*Aquí estamos creando las variables, con un valor nulo.
     */
    private var btnsing_up: Button? = null
    private var btnsing_up_google: Button? = null
    private var emailRegister: EditText? = null
    private var password1Register: EditText? = null
    private var usernameRegister: EditText? = null
    private var usernameRegister: EditText? = null

    /*En esta función daremos el valor a las variables que hemos creado anteriormente.
    * Le indicaremos la id del botón, imagen, etc..
    *
     */

    private var db = FirebaseFirestore.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        btnsing_up = findViewById<Button>(R.id.sing_up);
        btnsing_up_google = findViewById<Button>(R.id.sing_up_google);
        emailRegister = findViewById<EditText>(R.id.emailRegister);
        password1Register = findViewById<EditText>(R.id.password1Register);
        usernameRegister = findViewById<EditText>(R.id.usernameRegister);

        btnsing_up_google!!.setOnClickListener(this)
        btnsing_up!!.setOnClickListener(this)
        emailRegister!!.setOnClickListener(this)
        password1Register!!.setOnClickListener(this)


    }

    /*En esta función indicaremos lo que hará el botón, imagen, etc. cuando el usuario haga click.
    */
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.sing_up -> {
                if (emailRegister!!.text.isNotEmpty() && password1Register?.text!!.isNotEmpty()){
                    FirebaseAuth.getInstance().createUserWithEmailAndPassword(emailRegister!!.text.toString(),
                        password1Register!!.text.toString()).addOnCompleteListener{
                        if (it.isSuccessful){
                            db.collection("users").document(emailRegister!!.text.toString()).set(
                                    hashMapOf("pais" to "","phone" to "", "username" to  usernameRegister!!.text.toString())
                            )

                            val intent: Intent = Intent(this, Chats::class.java).apply {
                              putExtra("username", usernameRegister!!.text.toString())
                           }
                            startActivity(intent)

                        }else{
                            showAlert()
                        }
                    }

                }
            }
            R.id.sing_up_google -> {
                val intent: Intent = Intent(this, Chats::class.java)
                startActivity(intent)
            }
        }
    }

    private fun showAlert(){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Se ha producido un error, No se ha podido crear el usuario")
        builder.setPositiveButton("Aceptar",null)
        val dialog: AlertDialog =builder.create()
        dialog.show()
    }


}