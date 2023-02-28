package com.liquidforte.mush.server

import java.net.ServerSocket

class Server(val port: Int) {
    val socket: ServerSocket = ServerSocket(port)
    val clients: MutableList<ClientHandler> = mutableListOf()

    fun start() {

    }

    fun run() {
        val clientSocket = socket.accept()
        val handler = ClientHandler(clientSocket)
        handler.start()
        clients.add(handler)
    }
}