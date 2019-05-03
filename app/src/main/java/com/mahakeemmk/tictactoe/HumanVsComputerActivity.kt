package com.mahakeemmk.tictactoe

import android.graphics.Color
import android.graphics.drawable.Animatable
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ImageButton
import kotlinx.android.synthetic.main.game_board_layout.*

class HumanVsComputerActivity:AppCompatActivity() {

    var personOptions = ArrayList<Int>()
    var computerOptions = ArrayList<Int>()
    var disabledButtons = ArrayList<ImageButton>()
    var currentPlayer:Players? = null

    enum class Players {
        PERSON,
        COMPUTER
    }

    enum class Result {
        PERSONWON,
        COMPUTERWON,
        DRAW
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.game_board_layout)
        startComputer()
    }

    private fun startComputer() {
        selectComputerOption()
    }

    private fun selectComputerOption() {
        currentPlayer = Players.COMPUTER
        var option = computerOption()
        computerOptions.add(option)
        selectButton(option)
        switchPlayer()
    }

    fun onButtonClick(view: View) {
        when(view.id) {
            R.id.button1 -> selectOption(1)
            R.id.button2 -> selectOption(2)
            R.id.button3 -> selectOption(3)
            R.id.button4 -> selectOption(4)
            R.id.button5 -> selectOption(5)
            R.id.button6 -> selectOption(6)
            R.id.button7 -> selectOption(7)
            R.id.button8 -> selectOption(8)
            R.id.button9 -> selectOption(9)
        }
    }

    private fun selectOption(option:Int) {
        if (!(personOptions.contains(option)||computerOptions.contains(option))) {
            personOptions.add(option)
            selectButton(option)
            switchPlayer()
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
        if (currentPlayer == Players.PERSON) {
            currentPlayer = Players.COMPUTER
            startComputer()
        } else {
            currentPlayer = Players.PERSON
        }
    }

    private fun resetGame() {
        personOptions.clear()
        computerOptions.clear()
        for (button in disabledButtons) {
            resetButton(button)
        }
        disabledButtons.clear()
        startComputer()
    }

    private fun resetButton(button: ImageButton) {
        button.setImageResource(0)
        button.setBackgroundResource(R.drawable.custom_imagebutton_background)
        button.isEnabled = true
    }

    private fun getWinnerName(result: Result):String {
        return when(result) {
            Result.PERSONWON -> "PERSON WON"
            Result.COMPUTERWON -> "COMPUTER WON"
            Result.DRAW -> "DRAW"
        }
    }

    private fun selectButton(option: Int) {
        if (currentPlayer == Players.PERSON) {
            when(option) {
                1 -> {
                    button1.setImageResource(R.drawable.cross_animation)
                    val animatable:Animatable = button1.drawable as Animatable
                    animatable.start()
                    button1.isEnabled = false
                    disabledButtons.add(button1)
                }
                2 -> {
                    button2.setImageResource(R.drawable.cross_animation)
                    val animatable:Animatable = button2.drawable as Animatable
                    animatable.start()
                    button2.isEnabled = false
                    disabledButtons.add(button2)
                }
                3 -> {
                    button3.setImageResource(R.drawable.cross_animation)
                    val animatable:Animatable = button3.drawable as Animatable
                    animatable.start()
                    button3.isEnabled = false
                    disabledButtons.add(button3)
                }
                4 -> {
                    button4.setImageResource(R.drawable.cross_animation)
                    val animatable:Animatable = button4.drawable as Animatable
                    animatable.start()
                    button4.isEnabled = false
                    disabledButtons.add(button4)
                }
                5 -> {
                    button5.setImageResource(R.drawable.cross_animation)
                    val animatable:Animatable = button5.drawable as Animatable
                    animatable.start()
                    button5.isEnabled = false
                    disabledButtons.add(button5)
                }
                6 -> {
                    button6.setImageResource(R.drawable.cross_animation)
                    val animatable:Animatable = button6.drawable as Animatable
                    animatable.start()
                    button6.isEnabled = false
                    disabledButtons.add(button6)
                }
                7 -> {
                    button7.setImageResource(R.drawable.cross_animation)
                    val animatable:Animatable = button7.drawable as Animatable
                    animatable.start()
                    button7.isEnabled = false
                    disabledButtons.add(button7)
                }
                8 -> {
                    button8.setImageResource(R.drawable.cross_animation)
                    val animatable:Animatable = button8.drawable as Animatable
                    animatable.start()
                    button8.isEnabled = false
                    disabledButtons.add(button8)
                }
                9 -> {
                    button9.setImageResource(R.drawable.cross_animation)
                    val animatable:Animatable = button9.drawable as Animatable
                    animatable.start()
                    button9.isEnabled = false
                    disabledButtons.add(button9)
                }
            }
        } else {
            when(option) {
                1 -> {
                    button1.setImageResource(R.drawable.circle_animation)
                    val animatable:Animatable = button1.drawable as Animatable
                    animatable.start()
                    button1.isEnabled = false
                    disabledButtons.add(button1)
                }
                2 -> {
                    button2.setImageResource(R.drawable.circle_animation)
                    val animatable:Animatable = button2.drawable as Animatable
                    animatable.start()
                    button2.isEnabled = false
                    disabledButtons.add(button2)
                }
                3 -> {
                    button3.setImageResource(R.drawable.circle_animation)
                    val animatable:Animatable = button3.drawable as Animatable
                    animatable.start()
                    button3.isEnabled = false
                    disabledButtons.add(button3)
                }
                4 -> {
                    button4.setImageResource(R.drawable.circle_animation)
                    val animatable:Animatable = button4.drawable as Animatable
                    animatable.start()
                    button4.isEnabled = false
                    disabledButtons.add(button4)
                }
                5 -> {
                    button5.setImageResource(R.drawable.circle_animation)
                    val animatable:Animatable = button5.drawable as Animatable
                    animatable.start()
                    button5.isEnabled = false
                    disabledButtons.add(button5)
                }
                6 -> {
                    button6.setImageResource(R.drawable.circle_animation)
                    val animatable:Animatable = button6.drawable as Animatable
                    animatable.start()
                    button6.isEnabled = false
                    disabledButtons.add(button6)
                }
                7 -> {
                    button7.setImageResource(R.drawable.circle_animation)
                    val animatable:Animatable = button7.drawable as Animatable
                    animatable.start()
                    button7.isEnabled = false
                    disabledButtons.add(button7)
                }
                8 -> {
                    button8.setImageResource(R.drawable.circle_animation)
                    val animatable:Animatable = button8.drawable as Animatable
                    animatable.start()
                    button8.isEnabled = false
                    disabledButtons.add(button8)
                }
                9 -> {
                    button9.setImageResource(R.drawable.circle_animation)
                    val animatable:Animatable = button9.drawable as Animatable
                    animatable.start()
                    button9.isEnabled = false
                    disabledButtons.add(button9)
                }
            }
        }
    }

    fun computerOption() : Int {
        var option:Int
        do {
            option = getRandomNumber()
        } while (personOptions.contains(option)||computerOptions.contains(option))
        return option
    }

    private fun getRandomNumber():Int {
        var random = ((Math.random() * 9) + 1).toInt()
        return random
    }

    private fun checkWinner(): Result? {
        if (isRow(personOptions) || isColumn(personOptions) || isDiagonal(personOptions)) {
            return Result.PERSONWON
        } else if(isRow(computerOptions) || isColumn(computerOptions) || isDiagonal(computerOptions)) {
            return Result.COMPUTERWON
        } else {
            if ((personOptions.size + computerOptions.size) == 9) {
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

}