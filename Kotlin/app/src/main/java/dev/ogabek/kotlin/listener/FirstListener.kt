package dev.ogabek.kotlin.listener

import dev.ogabek.kotlin.model.Person

interface FirstListener {
    fun onFirstSend(person: Person)
}