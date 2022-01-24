package com.raul;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) throws IOException {

        ServerSocket socket = new ServerSocket(1024);
        Socket clienteSocket = socket.accept();

    }
}
