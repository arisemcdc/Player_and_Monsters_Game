package com.example.playerandmonstersgame.Model

import kotlin.random.Random

class Monster(
    override val attack: Int,
    override val protection: Int,
    override var health: Int,
    override val damage: IntRange
) : Creature(attack, protection, health, damage) {
    override fun hit(anotherCreature: Creature) {
        val attackModifier = attack - anotherCreature.protection
        val diceRoll = (1..attackModifier).map { Random.nextInt(1,6) }
        if (diceRoll.any({it == 5 || it == 6})) {
            anotherCreature.health -= damage.random()
        }
    }
}