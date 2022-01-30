package com.raul;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static final int MAX_PORT_NUMBER = 65535;
    public static final int MIN_PORT_NUMBER = 1;

    public static void main(String[] args) throws IOException {
        if (args.length < 1) {
            System.err.println("Usage: java Server <port number>");
            System.exit(1);
        }

        int portNumber = 0;
        try {
            portNumber = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            System.err.println("<port number> must be an integer value");
            System.exit(1);
        }

        if (portNumber < MIN_PORT_NUMBER || portNumber > MAX_PORT_NUMBER) {
            System.err.printf("<port number> must be an integrer value between %d and %d%n", MIN_PORT_NUMBER, MAX_PORT_NUMBER);
            System.exit(1);
        }

        try (
                ServerSocket socket = new ServerSocket(portNumber);
                Socket clienteSocket = socket.accept();
                BufferedReader socketIn = new BufferedReader(new InputStreamReader(clienteSocket.getInputStream()));
                PrintWriter socketOut = new PrintWriter(clienteSocket.getOutputStream(), true)
        ){
            String line;
            while ((line = socketIn.readLine()) != null) {
                socketOut.println(line);
            }
        }
    }
}
