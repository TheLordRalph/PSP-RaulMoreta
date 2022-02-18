package com.raul;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;

public class PeerConnection extends Thread implements Observer {
    private static final String COMMAND_START_CHAR = "/";
    private final Socket clientSocket;
    private final Observable observable;
    private final PrintWriter socketOut;
    private String nickname = "unknown";

    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
    Date fehcActual;

    public PeerConnection(Socket clientSocket, Observable observable) throws IOException {
        this.clientSocket = clientSocket;
        this.observable = observable;
        observable.addObserver(this);
        socketOut = new PrintWriter(clientSocket.getOutputStream(), true);
    }

    @Override
    public void run() {
        try (
                BufferedReader socketIn = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        ) {
            String line;
            while ((line = socketIn.readLine()) != null) {

                if (line.startsWith(COMMAND_START_CHAR)) {
                    String command = line.substring(1);
                    if (command.startsWith("nick")) {
                        String nickname = command.substring("nick".length() + 1);
                        if (nickname.length() > 0) {
                            this.nickname = nickname;
                        }
                    }
                } else {
                    fehcActual = new Date();
                    observable.notifyObservers(String.format("[%s] [%s] %s", sdf.format(fehcActual), this.nickname, line));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            socketOut.close();
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        socketOut.println(arg.toString());
    }
}
