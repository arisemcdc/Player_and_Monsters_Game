package com.example.playerandmonstersgame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.playerandmonstersgame.Model.Monster
import com.example.playerandmonstersgame.Model.Player

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val player = Player(10, 15, 100, 1..6)
        val monster = Monster(5, 10,50,1..6)
        while (player.health > 0 && monster.health > 0) {
            player.hit(monster)
            monster.hit(player)
        }
        Log.d("MainActivity", "Игрок победил")
        println( "Игрок победил!")
    }
}