package com.example.atividade9

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)
        //criando o adaptador
        val produtosAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1)
        val precoAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1)

        val listViewProdutos = findViewById<ListView>(R.id.ListViewProdutos)
        val listViewPreco = findViewById<ListView>(R.id.ListViewPreco)
        val btnInserir = findViewById<Button>(R.id.btnInserir)
        val txtProduto = findViewById<TextView>(R.id.txtProduto)
        val txtPreco = findViewById<TextView>(R.id.txtPreco)

        listViewProdutos.adapter = produtosAdapter
        listViewPreco.adapter = precoAdapter

        btnInserir.setOnClickListener() {
            val produto = txtProduto.text.toString()
            val preco = txtPreco.text.toString()
            if ((produto.isNotEmpty()) && (preco.isNotEmpty())) {
                produtosAdapter.add(produto)
                precoAdapter.add(preco)
                txtProduto.text = ""
                txtPreco.text = ""
            } else {
                txtProduto.error = "Coloque um produto"
                txtPreco.error = "Coloque um preco"
            }

            listViewProdutos.setOnItemClickListener { adapterView: AdapterView<*>, view, position: Int, id: Long ->

                val item = produtosAdapter.getItem(position)

                produtosAdapter.remove(item)
            }
            listViewPreco.setOnItemClickListener { adapterView: AdapterView<*>, view, position: Int, id: Long ->

                val item = precoAdapter.getItem(position)

                precoAdapter.remove(item)

            }
        }
    }
}