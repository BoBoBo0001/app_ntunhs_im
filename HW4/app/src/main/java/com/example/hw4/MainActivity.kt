package com.example.hw4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import java.util.Random

class MainActivity : AppCompatActivity() {
    private  lateinit var  txtCom: ImageView
    private  lateinit var  txtResult: TextView
    private  lateinit var  btnScissors: ImageButton
    private  lateinit var  btnRock: ImageButton
    private  lateinit var  btnPaper: ImageButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        txtCom = findViewById(R.id.txtCom)
        txtResult = findViewById(R.id.txtResult)
        btnScissors = findViewById(R.id.imbtnScissors)
        btnRock = findViewById(R.id.imbtnRock)
        btnPaper = findViewById(R.id.imbtnPaper)

        txtCom = findViewById(R.id.txtCom)

        btnRock.setOnClickListener{
            playGame(Choice.rock)
        }
        btnScissors.setOnClickListener{
            playGame(Choice.scissor)
        }
        btnPaper.setOnClickListener{
            playGame(Choice.paper)
        }
    }

    enum class Choice{
        scissor, rock, paper
    }
    fun playGame(playerChoice: Choice){
        val choices = Choice.values()
        val computerChoice = choices[Random().nextInt(choices.size)]

        when{
            playerChoice == computerChoice ->{
                //txtCom .setText(getChoiceString(computerChoice))
                txtResult.setText(R.string.draw)
            }
            (playerChoice == Choice.scissor && computerChoice == Choice.paper) ||
                    (playerChoice == Choice.rock && computerChoice == Choice.scissor) ||
                    (playerChoice == Choice.paper && computerChoice == Choice.rock) -> {
                //txtCom.setText(getChoiceString(computerChoice))
                txtResult.setText(R.string.win)
            }
            else ->{
                //txtCom.setText(getChoiceString(computerChoice))
                txtResult.setText(R.string.lose)
            }
        }

        when{
            computerChoice == Choice.scissor ->{
                txtCom.setImageResource(R.drawable.scissor)
            }
            computerChoice == Choice.rock ->{
                txtCom.setImageResource(R.drawable.rock)
            }
            computerChoice == Choice.paper ->{
                txtCom.setImageResource(R.drawable.paper)
            }
        }
    }
    fun getChoiceString(choice: Choice):Int {
        return when (choice) {
            Choice.scissor -> R.string.scissors
            Choice.rock -> R.string.rock
            Choice.paper -> R.string.paper
        }
    }
}