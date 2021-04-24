package com.example.atividade9

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        val txtCelsius = findViewById<EditText>(R.id.txtCelsius)
        val txtResultado = findViewById<TextView>(R.id.txt_Resultado)
        val btnConverter = findViewById<Button>(R.id.btnConverter)
        val btnNext = findViewById<Button>(R.id.btn_next2)
        val btnLimpar = findViewById<Button>(R.id.btn_limpar2)

        btnConverter.setOnClickListener(){
            //CTRL+ALT+L
            if (txtCelsius.text.isEmpty()){
                // validação de dados
                txtCelsius.error = "Digite a temperatura em Celsius"
            }else{
                //entrada de dados
                val celsius = txtCelsius.text.toString().toDouble()
                //processamento
                val resultado: Double
                resultado = (9*celsius + 160)/5
                txtResultado.text = "$celsius Graus Celsius equivale a $resultado Graus Fahrenheit"
                txtCelsius.text.clear()
            }

        }

        btnNext.setOnClickListener {
            val proximaTela = Intent(this,MainActivity4::class.java)
            startActivity(proximaTela)
        }

        btnLimpar.setOnClickListener {
            if (txtCelsius.text.isEmpty()){
                txtCelsius.text.clear()
                txtResultado.text = null
            }
        }
    }
}