package com.example


class App {

    fun hello() = "Hello, world!"

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            val app = App()
            System.out.println(app.hello())
        }
    }

}
