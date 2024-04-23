package com.example.guess_number

import androidx.appcompat.app.AppCompatActivity
import com.example.guess_number.databinding.ActivityMainBinding
import com.example.guess_number.GuessingGame
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.*
import java.util.*

class MainActivity : AppCompatActivity() {
    //val TAG: String = MainActivity::class.java.simpleName
    private lateinit var  handler: Handler
    private lateinit var  binding: ActivityMainBinding
    private val game = GuessingGame()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        handler = Handler(Looper.getMainLooper())
        /*
        val textView = findViewById<TextView>(R.id.textView)
        val editText = findViewById<EditText>(R.id.editText)
        val button1 = findViewById<Button>(R.id.button)
        val button2 = findViewById<Button>(R.id.button2)
        var num : Int

        var secret : Int = Random().nextInt(100)+1
        var max : Int = 100
        var min : Int = 1
        */

        binding.button.setOnClickListener{
            val guessNum = binding.editText.text.toString().toInt()
            val resultText = game.guessNumber(guessNum)
            binding.textView.text = resultText + "\n" +game.getRangeText()
            if (resultText == "猜對了") {
                handler.postDelayed({
                    Toast.makeText(this, "六秒後重置", Toast.LENGTH_SHORT).show()
                    game.resetGame()
                    binding.textView.text = "再猜一次"
                    binding.textView.text = "下一回合"
                }, 6000)
            }

            /*num = editText.text.toString().toInt() - secret
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
                    Toast.makeText(this,"經過6秒，已重置!",Toast.LENGTH_SHORT).show()
                },6000)
                textView.text = "結果會顯示在這裡"
            }
            textView.text = ans_str
            */
        }

        binding.button2.setOnClickListener{
            game.resetGame()
            binding.textView.text = "再猜一次"
            /*
            secret = Random().nextInt(100)+1
            max = 100
            min = 1
            textView.text = "結果會顯示在這裡"
            Toast.makeText(this,"數字已經重置",Toast.LENGTH_SHORT)
            */
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacksAndMessages(null)
    }
}