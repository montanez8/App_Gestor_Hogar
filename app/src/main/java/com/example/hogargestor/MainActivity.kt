package com.example.hogargestor
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    private var edt_username: EditText?=null
    private var edt_password:EditText?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edt_username=findViewById(R.id.editTextnameCreate)
        edt_password=findViewById(R.id.editTextTextPassword)
    }


    fun registeruser(view: View) {
        val intento = Intent(this,Register_user::class.java)
        startActivity(intento)
    }

    fun onlogin(view: View) {
        if (edt_username!!.text.toString()=="carlos@gmail.com"){
            if (edt_password!!.text.toString()=="1234"){
                val intento =Intent(this,welcome::class.java)
                startActivity(intento)
            }else{
                val dialogo= AlertDialog.Builder(this).setTitle("Error")
                    .setMessage("Invalid username or password").create().show()
            }
        }
    }
}