package com.example.atividade9

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn_login = findViewById<Button>(R.id.btn_login)
        val txt_login = findViewById<EditText>(R.id.txt_login)
        val txt_senha = findViewById<EditText>(R.id.txt_senha)
        var txt_Resultado = findViewById<TextView>(R.id.txt_Resultado)

        btn_login.setOnClickListener{
            var Login: String = txt_login.getText().toString()
            var Senha: String = txt_senha.getText().toString()
            if ((Login == "cristiano") && (Senha == "fatec")){
                txt_Resultado.text= "Login Efetuado com Sucesso"
                val proximaTela2 = Intent(this,MainActivity2::class.java)
                startActivity(proximaTela2)
            }else{
                txt_Resultado.text = "Senha ou Usuario Inválido!!!"
            }

        }
    }
}