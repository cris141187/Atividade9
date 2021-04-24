package com.example.atividade9

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        //habilitar os campos para entrada e/ou saida
        val txt_Ano = findViewById<EditText>(R.id.txt_Ano)
        val txt_Mes = findViewById<EditText>(R.id.txt_Mes)
        val txt_Dia = findViewById<EditText>(R.id.txt_Dia)
        val txt_Resultado = findViewById<TextView>(R.id.txt_Resultado)
        val btn_Converter = findViewById<Button>(R.id.btn_Converter)
        val btn_Limpar = findViewById<Button>(R.id.btn_Limpar)
        val btn_Next = findViewById<Button>(R.id.btn_Next)

        btn_Converter.setOnClickListener {
            //entrada de dados
            if (txt_Ano.text.isEmpty()) {
                txt_Ano.error = "Digite a quantidade de ano(s)"
            } else if (txt_Mes.text.isEmpty()) {
                txt_Mes.error = "Digite a quantidade de mes(es)"
            } else if (txt_Dia.text.isEmpty()) {
                txt_Dia.error = "Digite a quantidade de dia(s)"
            } else {
                val ano = txt_Ano.text.toString().toInt()
                val mes = txt_Mes.text.toString().toInt()
                val dia = txt_Dia.text.toString().toInt()
                //processamento
                val resultado: Int
                resultado = ano * 360 + mes * 30 + dia
                //saida
                txt_Resultado.text = "Voce tem $resultado dia(s)"
            }
        }

        btn_Limpar.setOnClickListener {
            txt_Ano.text.clear()
            txt_Mes.text.clear()
            txt_Dia.text.clear()
            txt_Resultado.text = null

        }
        btn_Next.setOnClickListener {
            val proximaTela = Intent(this,MainActivity3::class.java)
            startActivity(proximaTela)
        }
    }
}