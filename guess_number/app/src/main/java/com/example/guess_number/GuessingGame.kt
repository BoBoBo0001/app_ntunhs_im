package com.example.guess_number

import java.util.Random

class GuessingGame {
    private var secret : Int = Random().nextInt(100)+1
    var max : Int = 100
    var min : Int = 1

    fun guessNumber(guess: Int): String {
        if (guess > max || guess < min) {
            return "請輸入位於${min}~${max}的數字"
        }

        when {
            guess > secret -> {
                max = guess
                return "你猜的比較大喔"
            }
            guess < secret -> {
                min = guess
                return "你猜的比較小喔"
            }
            else -> {
                resetGame()  // Reset game on correct guess
                return "猜對了"
            }
        }
    }

    fun getRangeText(): String = "$min~$max"

    fun resetGame() {
        secret = Random().nextInt(100) + 1
        max = 100
        min = 0
    }
}