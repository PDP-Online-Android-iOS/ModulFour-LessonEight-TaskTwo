package dev.ogabek.kotlin.listener

import dev.ogabek.kotlin.model.Person

interface SecondListener {
    fun onSecondSend(person: Person)
}