package com.mahakeemmk.tictactoe

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        human_human_btn.setOnClickListener {
            var intent = Intent(this,HumanVsHumanActivity::class.java)
            startActivity(intent)
        }

        human_computer_btn.setOnClickListener {
            var intent = Intent(this,HumanVsComputerActivity::class.java)
            startActivity(intent)
        }
    }
}
