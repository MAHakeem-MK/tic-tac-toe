package com.mahakeemmk.tictactoe

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.view.View
import android.widget.ImageButton
import kotlinx.android.synthetic.main.game_board_layout.*

class HumanVsHumanActivity : AppCompatActivity() {

    enum class Player{
        PLAYER1,
        PLAYER2;
    }

    enum class Result{
        PLAYER1WON,
        PLAYER2WON,
        DRAW
    }

    var currentPlayer:Player = Player.PLAYER1
    var player1Options:ArrayList<Int> = ArrayList()
    var player2Options:ArrayList<Int> = ArrayList()
    var disabledButtons:ArrayList<ImageButton> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.game_board_layout)
        startGame()
    }

    fun startGame() {
        setTitle()
    }

    private fun setTitle() {
        if (currentPlayer == Player.PLAYER1) {
            player_title.text = "PLAYER 1"
        } else {
            player_title.text = "PLAYER 2"
        }
    }

    private fun getWinnerName(result:Result):String {
        return when(result) {
            Result.PLAYER1WON -> "PLAYER 1 WON"
            Result.PLAYER2WON -> "PLAYER 2 WON"
            Result.DRAW -> "DRAW"
        }
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
        } else {
            player2Options.add(option)
            button.setImageResource(R.drawable.ic_circle_black_24dp)
            disableButton(button)
            switchPlayer()
        }
    }

    private fun resetGame() {
        player1Options.clear()
        player2Options.clear()
        for (button in disabledButtons) {
            resetButton(button)
        }
        disabledButtons.clear()
        startGame()
    }

    private fun resetButton(button: ImageButton) {
        button.setImageResource(0)
        button.setBackgroundResource(R.drawable.custom_imagebutton_background)
        button.isEnabled = true
    }

    private fun checkWinner():Result? {
        if (isRow(player1Options) || isColumn(player1Options) || isDiagonal(player1Options)) {
           return Result.PLAYER1WON
        } else if(isRow(player2Options) || isColumn(player2Options) || isDiagonal(player2Options)) {
            return Result.PLAYER2WON
        } else {
            if ((player1Options.size + player2Options.size) == 9) {
                return Result.DRAW
            }
        }
        return null
    }

    private fun isRow(array:ArrayList<Int>) : Boolean{
        with(array) {
            if (contains(1)&&contains(2)&&contains(3)) {
                button1.setBackgroundColor(Color.GREEN)
                button2.setBackgroundColor(Color.GREEN)
                button3.setBackgroundColor(Color.GREEN)
                return true
            } else if (contains(4)&&contains(5)&&contains(6)) {
                button4.setBackgroundColor(Color.GREEN)
                button5.setBackgroundColor(Color.GREEN)
                button6.setBackgroundColor(Color.GREEN)
                return true
            } else if (contains(7)&&contains(8)&&contains(9)) {
                button7.setBackgroundColor(Color.GREEN)
                button8.setBackgroundColor(Color.GREEN)
                button9.setBackgroundColor(Color.GREEN)
                return true
            } else {
                return false
            }
        }
    }

    private fun isColumn(array:ArrayList<Int>) : Boolean{
        with(array) {
            if (contains(1)&&contains(4)&&contains(7)) {
                button1.setBackgroundColor(Color.GREEN)
                button4.setBackgroundColor(Color.GREEN)
                button7.setBackgroundColor(Color.GREEN)
                return true
            } else if (contains(2)&&contains(5)&&contains(8)) {
                button2.setBackgroundColor(Color.GREEN)
                button5.setBackgroundColor(Color.GREEN)
                button8.setBackgroundColor(Color.GREEN)
                return true
            } else if (contains(3)&&contains(6)&&contains(9)) {
                button3.setBackgroundColor(Color.GREEN)
                button6.setBackgroundColor(Color.GREEN)
                button9.setBackgroundColor(Color.GREEN)
                return true
            } else {
                return false
            }
        }
    }

    private fun isDiagonal(array:ArrayList<Int>) : Boolean{
        with(array) {
            if (contains(1)&&contains(5)&&contains(9)) {
                button1.setBackgroundColor(Color.GREEN)
                button5.setBackgroundColor(Color.GREEN)
                button9.setBackgroundColor(Color.GREEN)
                return true
            } else if (contains(3)&&contains(5)&&contains(7)) {
                button3.setBackgroundColor(Color.GREEN)
                button5.setBackgroundColor(Color.GREEN)
                button7.setBackgroundColor(Color.GREEN)
                return true
            } else {
                return false
            }
        }
    }

    private fun switchPlayer() {
        var result = checkWinner()
        if (result != null) {
            AlertDialog.Builder(this)
                .setTitle(getWinnerName(result))
                .setCancelable(false)
                .setPositiveButton("OK",{
                        dialog, which ->
                    resetGame()
                }).show()
            return
        }
        if (currentPlayer == Player.PLAYER1) {
            currentPlayer = Player.PLAYER2
            player_title.text = "PLAYER 2"
        } else {
            currentPlayer = Player.PLAYER1
            player_title.text = "PLAYER 1"
        }
    }

    private fun disableButton(button: ImageButton) {
        button.isEnabled = false
        disabledButtons.add(button)
    }

}
