package com.raul;

public class CenaFilosofos {


    public synchronized void cojerTenedor(Tenedor tenedorIzquierda, Tenedor tenedorDerecha) throws InterruptedException {
        while (!tenedorIzquierda.disponible || !tenedorDerecha.disponible) {
            wait();
        }
        tenedorIzquierda.disponible = false;
        tenedorDerecha.disponible = false;
        notifyAll();
    }

    public synchronized void dejarTenedores(Tenedor tenedorIzquierda, Tenedor tenedorDerecha) {
        tenedorIzquierda.disponible = true;
        tenedorDerecha.disponible = true;
        notifyAll();
    }
}
