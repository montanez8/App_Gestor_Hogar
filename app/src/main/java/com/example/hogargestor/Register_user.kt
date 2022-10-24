package com.example.hogargestor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import java.util.regex.Pattern

class Register_user : AppCompatActivity() {
    private var edname : EditText? = null;
    private var edlastname : EditText? = null;
    private var ediduser : EditText? = null;
    private var edemail : EditText? = null;
    private var edphone : EditText? = null;
    private var edpassword : EditText? = null;
    private var chpolicies : CheckBox? = null;
    /*con esta propiedad podemos validar un campo de texto*/
    private val text_pattern :Pattern =Pattern.compile("^[a-zA-Z-ñÑ]+$")
    private val password_pattern :Pattern =Pattern.compile( "^(?:(?=.*\\d)(?=.*[a-z]).*)[^\\s]{8,}$")
    private val  email_pattern :Pattern =Pattern.compile( "^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}$")



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_user)
        edname = findViewById(R.id.editTextnameCreate)
        edlastname =findViewById(R.id.editTextLastcreate)
        ediduser = findViewById(R.id.editTextNumber)
        edemail = findViewById(R.id.editTextEmailAddress)
        edphone = findViewById(R.id.editTextPhone)
        edpassword = findViewById(R.id.editTextPasswordcreate)
        chpolicies = findViewById(R.id.checkBox_Create)


    }
    fun onregistersave(view: View) {
        if (validatecreate()) {
            Toast.makeText(this, getString(R.string.valid_correct), Toast.LENGTH_SHORT).show()

        }else{
            Toast.makeText(this, getString(R.string.valid_error), Toast.LENGTH_SHORT).show()
        }

    }
    private fun validatecreate():Boolean{
        var valid = true
        if(edname?.text.toString().isEmpty()){
            edname?.error = getString(R.string.val_name_is_required)
            valid = false
        }else if(!text_pattern.matcher(edname?.text.toString()).matches()){
            edname?.error = getString(R.string.valid_name_letter)
            valid = false
        }
        if(edlastname?.text.toString().isEmpty()){
            edlastname?.error = getString(R.string.valid_last_name_is_required)
            valid = false
        }else if(!text_pattern.matcher(edlastname?.text.toString()).matches()){
            edlastname?.error = getString(R.string.valid_last_name_ontain_letters)
            valid = false
        }
        if(ediduser?.text.toString().isEmpty()){
            ediduser?.error = getString(R.string.valid_identification_is_required)
            valid = false
        }
        if(edemail?.text.toString().isEmpty()){
            edemail?.error = getString(R.string.valid_email_is_required)
            valid = false
        }else{
            if(!email_pattern.matcher(edemail?.text.toString()).matches()){
                edemail?.error = getString(R.string.valid_email_is_not_valid)
                valid = false
            }
        }
        if(edphone?.text.toString().isEmpty()){
            edphone?.error = getString(R.string.valid_phone_is_required)
            valid = false
        }
        if(edpassword?.text.toString().isEmpty()){
            edpassword?.error = getString(R.string.valid_password_is_required)
            valid = false
        }else{
            if(!password_pattern.matcher(edpassword?.text.toString()).matches()){
                edpassword?.error = getString(R.string.valid_password_is_required)
                valid = false
            }
        }
        if(!chpolicies?.isChecked!!){
            chpolicies?.error = getString(R.string.valid_accept_the_policies)
            valid = false
        }


        return valid
    }
}