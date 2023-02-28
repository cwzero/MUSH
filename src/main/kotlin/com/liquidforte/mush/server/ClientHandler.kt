package com.liquidforte.mush.server

import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.net.Socket

class ClientHandler(val socket: Socket) {
    fun start() {
        runBlocking {
            launch {
                run()
            }
        }
    }

    fun run() {
        
    }
}