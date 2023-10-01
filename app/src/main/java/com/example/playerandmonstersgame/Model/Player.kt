package com.example.playerandmonstersgame.Model

import android.util.Log
import kotlin.random.Random

class Player(override val attack: Int,
             override val protection: Int,
             override var health: Int,
             override val damage: IntRange): Creature(attack, protection, health ,damage ) {
    private var healings = 4
    override fun hit(anotherCreature: Creature) {
        val attackModifier = attack - anotherCreature.protection
        val diceRoll = (1..attackModifier).map { Random.nextInt(1, 6) }
        if (diceRoll.any({ it == 5 || it == 6 })) {
            anotherCreature.health -= damage.random()
        }
    }
    override fun heal() {
        if (healings == 0) {
            throw java.lang.IllegalArgumentException("Исцеления закончились")
            Log.d("MainActivity", "Монстр победил")
        }
        else {
            healings--
            health += (health *0.3).toInt()
        }
    }
}