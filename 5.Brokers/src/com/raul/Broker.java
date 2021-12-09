package com.raul;

public class Broker {

    private static int _acciones;


    public Broker (int acciones) {
        _acciones = acciones;
    }

    public synchronized boolean buy(int paqueteDeAcciones) {

        System.out.printf("Broker: there's %d available shares %n", _acciones);
        if ((_acciones - paqueteDeAcciones) >= 0) {
            _acciones -= paqueteDeAcciones;
            System.out.printf("Broker: now there's %d available shares %n", _acciones);
            notifyAll();
            return true;
        } else {
            notifyAll();
            return false;
        }
    }

    public synchronized void waitUntilNoSharesAvailable() throws InterruptedException {
        while (_acciones > 0) {
            wait();
        }
        notifyAll();
    }

}
