package com.izax.pruebaesme

import android.os.Bundle
import android.util.Patterns
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.regex.Pattern


class MainActivity : AppCompatActivity() {

    var phone: String = ""
    var number: String = ""
    var email: String = ""
    var pass: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        botones()

    }

    fun valores(){
        number = txtNumero.text.toString()
        phone = txtPhone.text.toString()
        email = txtEmail.text.toString()
        pass = txtPass.text.toString()
    }

    fun validarCampos(){
        valores()

        if (number.count() > 15){

        }else{
            txtNumero.error = "Campo para 16 Digitos";
        }

        if (phone.count() > 9){

        }else{
            txtPhone.error = "Campo para 10 Digitos";
        }

        if (!validarEmail(email)){
            txtEmail.error = "Formato incorrecto";
        }

        if (pass.count() > 4){

        }else{
            txtPass.error = "Campo para un rango de 5 a 10";
        }

    }

    fun botones(){
        btnRegistrar.setOnClickListener(View.OnClickListener {
            validarCampos()
        })
    }

    private fun validarEmail(email: String): Boolean {
        val pattern: Pattern = Patterns.EMAIL_ADDRESS
        return pattern.matcher(email).matches()
    }
}