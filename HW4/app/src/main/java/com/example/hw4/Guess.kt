package com.example.hw4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.util.Random

class Guess : AppCompatActivity() {
    val TAG: String = MainActivity::class.java.simpleName
    private lateinit var  handler: Handler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guess)

        handler = Handler(Looper.getMainLooper())

        val textView = findViewById<TextView>(R.id.textNumberResult)
        val editText = findViewById<EditText>(R.id.editGuess)
        val button1 = findViewById<Button>(R.id.btnRoll)
        val button2 = findViewById<Button>(R.id.btnReset)
        val btnGuessBack = findViewById<Button>(R.id.btnGuessBack)

        var num : Int
        var secret : Int = Random().nextInt(100)+1
        var max : Int = 100
        var min : Int = 1

        button1.setOnClickListener{
            num = editText.text.toString().toInt() - secret
            var ans_str : String = "BINGO"

            if(num > 0){
                max = editText.text.toString().toInt()
                ans_str = min.toString() +"~"+ max.toString()
            }
            else if(num < 0){
                min = editText.text.toString().toInt()
                ans_str = min.toString() +"~"+ max.toString()
            }
            else{
                secret = Random().nextInt(100)+1
                max = 100
                min = 1
                handler.postDelayed({
                    Toast.makeText(this,"經過6秒，已重置!", Toast.LENGTH_SHORT).show()
                },6000)
                textView.text = "結果會顯示在這裡"
            }
            textView.text = ans_str
        }

        button2.setOnClickListener{
            secret = Random().nextInt(100)+1
            max = 100
            min = 1
            textView.text = "結果會顯示在這裡"
            Toast.makeText(this,"數字已經重置", Toast.LENGTH_SHORT)
        }

        btnGuessBack.setOnClickListener{
            var seconIntent = Intent(this,FirstActivity::class.java)
            startActivity(seconIntent)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacksAndMessages(null)
    }

}