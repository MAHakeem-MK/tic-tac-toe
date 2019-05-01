package com.mahakeemmk.tictactoe

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageButton
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    enum class Player{
        PLAYER1,
        PLAYER2;
    }

    enum class result{
        PLAYER1WIN,
        PLAYER2WIN,
        NOONE
    }

    var selectedOption:Int = 0
    var currentPlayer:Player = Player.PLAYER1
    var player1Options:ArrayList<Int> = ArrayList()
    var player2Options:ArrayList<Int> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startGame()
    }

    fun onButtonClick(view: View) {
        var selectedButton = view as ImageButton
        when(view.id) {
            R.id.button1 -> {
                selectOption(1,currentPlayer,selectedButton)
            }
            R.id.button2 -> {
                selectOption(2,currentPlayer,selectedButton)
            }
            R.id.button3 -> {
                selectOption(3,currentPlayer,selectedButton)
            }
            R.id.button4 -> {
                selectOption(4,currentPlayer,selectedButton)
            }
            R.id.button5 -> {
                selectOption(5,currentPlayer,selectedButton)
            }
            R.id.button6 -> {
                selectOption(6,currentPlayer,selectedButton)
            }
            R.id.button7 -> {
                selectOption(7,currentPlayer,selectedButton)
            }
            R.id.button8 -> {
                selectOption(8,currentPlayer,selectedButton)
            }
            R.id.button9 -> {
                selectOption(9,currentPlayer,selectedButton)
            }
        }
    }

    private fun selectOption(option: Int, currentPlayer: Player?,button:ImageButton) {
        if (currentPlayer == Player.PLAYER1) {
            player1Options.add(option)
            button.setImageResource(R.drawable.ic_close_black_24dp)
            disableButton(button)
            switchPlayer()
            return
        } else {
            player2Options.add(option)
            button.setImageResource(R.drawable.ic_circle_black_24dp)
            disableButton(button)
            switchPlayer()
        }
    }

    private fun switchPlayer() {
        if (currentPlayer == Player.PLAYER1) currentPlayer = Player.PLAYER2 else currentPlayer = Player.PLAYER1
    }

    private fun disableButton(button: ImageButton) {
        button.isEnabled = false
    }

    fun startGame() {
        if (currentPlayer == Player.PLAYER1) {
            player_title.text = "PLAYER 1"
        } else {
            player_title.text = "PLAYER 2"
        }
    }
}
