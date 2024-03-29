package com.example.hw4

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class FirstActivity : AppCompatActivity() {
    private  lateinit var  btnGuess : Button
    private  lateinit var  btnPaper : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)
        btnGuess = findViewById(R.id.btnGuess)
        btnPaper = findViewById(R.id.btnPaper)

        //猜數字
        btnGuess.setOnClickListener{
            //var bundle = Bundle()
            //var name = edtName.text.toString()
            //bundle.putString("name",name)

            var seconIntent = Intent(this,Guess::class.java)
            //seconIntent.putExtra("key",bundle)
            startActivity(seconIntent)
        }

        //猜拳
        btnPaper.setOnClickListener{
            var seconIntent = Intent(this,MainActivity::class.java)
            startActivity(seconIntent)
        }
    }
}