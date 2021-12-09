package com.raul;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Broker broker = new Broker(20);

        Client Maria = new Client("María", broker);
        Client Vanesa = new Client("Vanesa", broker);
        Client Luis = new Client("Luis", broker);
        Client Roberto = new Client("Roberto", broker);
        Client Antonio = new Client("Antonio", broker);

        Maria.start();
        Vanesa.start();
        Luis.start();
        Roberto.start();
        Antonio.start();

        broker.waitUntilNoSharesAvailable();

        Maria.interrupt();
        Vanesa.interrupt();
        Luis.interrupt();
        Roberto.interrupt();
        Antonio.interrupt();

        Maria.join();
        Vanesa.join();
        Luis.join();
        Roberto.join();
        Antonio.join();
    }
}
