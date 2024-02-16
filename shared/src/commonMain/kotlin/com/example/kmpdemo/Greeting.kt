package com.example.kmpdemo

class Greeting {
    private val platform: Platform = getPlatform()

    fun greet(): String {
        return "Hello, ${platform.name}! Bhai sahab kya haal hai?"
    }
}