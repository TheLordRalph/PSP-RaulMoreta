package com.raul;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.raul.Observable;
import com.raul.Observer;

public class PeerConnection extends Thread implements Observer {
    private static final String COMMAND_START_CHAR = "/";
    private final Socket clientSocket;
    private final Observable observable;
    private final PrintWriter socketOut;
    protected String nickname = "unknown";

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
                    } else if (command.startsWith("priv")) {
                        String user = command.substring("priv".length() + 1, command.lastIndexOf(COMMAND_START_CHAR));
                        line = command.substring(command.lastIndexOf(COMMAND_START_CHAR) + 1);

                        fehcActual = new Date();
                        observable.notifyObserver(String.format("[%s] [%s] [private to: %s] %s", sdf.format(fehcActual), this.nickname, user, line), nickname);
                        observable.notifyObserver(String.format("[%s] [%s] [private to: %s] %s", sdf.format(fehcActual), this.nickname, user, line), user);
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
