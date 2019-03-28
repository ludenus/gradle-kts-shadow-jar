package com.example

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class AppTest {

    @Test
    fun checkHello() {
        val sut = App()
        assertEquals("Hello, world!", sut.hello())
    }

}
