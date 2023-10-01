package com.example.playerandmonstersgame.Model

abstract class Creature(attack: Int, protection: Int, health: Int, damage: IntRange) {
   abstract val attack: Int
   abstract val protection: Int
   abstract var health: Int
   abstract val damage: IntRange
   abstract fun hit(anotherCreature: Creature)
   open fun heal() {
      if (health <0) {
         throw IllegalArgumentException("Здоровье не может быть отрицательным")
      }
      if (health == 0) {
         return
      }
   }
}
