package com.kavin.tic_tac_game

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun buClick(view: View) {
        val buSelected = view as Button
        var cellId = 0
        when (buSelected.id) {
            R.id.bu1 -> cellId = 1
            R.id.bu2 -> cellId = 2
            R.id.bu3 -> cellId = 3
            R.id.bu4 -> cellId = 4
            R.id.bu5 -> cellId = 5
            R.id.bu6 -> cellId = 6
            R.id.bu7 -> cellId = 7
            R.id.bu8 -> cellId = 8
            R.id.bu9 -> cellId = 9
        }
        playGame(cellId, buSelected)
    }

    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()

    var activeplayer = 1

    private fun playGame(cellId: Int, buSelected: Button) {
        if (activeplayer == 1) {
            buSelected.text = "X"
            buSelected.setBackgroundColor(Color.parseColor("#009193"))
            player1.add(cellId)
            activeplayer = 2
            AutoPlay()
        } else if (activeplayer == 2) {
            buSelected.text = "0"
            buSelected.setBackgroundColor(Color.parseColor("#FF9300"))
            player2.add(cellId)
            activeplayer = 1
        }

        buSelected.isEnabled = false

        checkWinner()
    }



    private fun checkWinner() {
        var winner = -1
        if (player1.contains(1) && player1.contains(2) && player1.contains(3)) {
            winner = 1
        }
        if (player2.contains(1) && player2.contains(2) && player2.contains(3)) {
            winner = 2
        }
        if (player1.contains(4) && player1.contains(5) && player1.contains(6)) {
            winner = 1
        }
        if (player2.contains(4) && player2.contains(5) && player2.contains(6)) {
            winner = 2
        }
        if (player1.contains(7) && player1.contains(8) && player1.contains(9)) {
            winner = 1
        }
        if (player2.contains(7) && player2.contains(8) && player2.contains(9)) {
            winner = 2
        }
        if (player1.contains(1) && player1.contains(4) && player1.contains(7)) {
            winner = 1
        }
        if (player2.contains(1) && player2.contains(4) && player2.contains(7)) {
            winner = 2
        }
        if (player1.contains(2) && player1.contains(5) && player1.contains(8)) {
            winner = 1
        }
        if (player2.contains(2) && player2.contains(5) && player2.contains(8)) {
            winner = 2
        }
        if (player1.contains(3) && player1.contains(6) && player1.contains(9)) {
            winner = 1
        }
        if (player2.contains(3) && player2.contains(6) && player2.contains(9)) {
            winner = 2
        }
        if (player1.contains(1) && player1.contains(5) && player1.contains(9)) {
            winner = 1
        }
        if (player2.contains(1) && player2.contains(5) && player2.contains(9)) {
            winner = 2
        }
        if (player1.contains(3) && player1.contains(5) && player1.contains(7)) {
            winner = 1
        }
        if (player2.contains(3) && player2.contains(5) && player2.contains(7)) {
            winner = 2
        }

        if (winner != -1) {
            if (winner == 1) {
                Toast.makeText(this, "Player 1 won the match", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Player 2 won the match", Toast.LENGTH_LONG).show()
            }
        }
    }
    private fun AutoPlay() {
        var emptyCells = ArrayList<Int>()
        for (cellId in 1..9) {
            if (!(player1.contains(cellId) || player2.contains(cellId))) {
                emptyCells.add(cellId)
            }
        }
        val r = Random()
        val randIndex = r.nextInt(emptyCells.size - 0) + 0
        val cellId=emptyCells [randIndex]

        val buSelected: Button
        when (cellId) {
            1 -> buSelected = bu1
            2 -> buSelected = bu2
            3 -> buSelected = bu3
            4 -> buSelected = bu4
            5 -> buSelected = bu5
            6 -> buSelected = bu6
            7 -> buSelected = bu7
            8 -> buSelected = bu8
            9 -> buSelected = bu9
            else -> buSelected = bu1
        }
        playGame(cellId as Int, buSelected)

    }
}
