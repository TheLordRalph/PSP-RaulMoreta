package com.raul;

import java.sql.SQLOutput;

public class Filosofo extends Thread {


    private final CenaFilosofos _cenaFilosofos;
    private final Tenedor _tenedorIzquierda;
    private final Tenedor _tenedorDerecha;

    public Filosofo(int number, CenaFilosofos cenaFilosofos, Tenedor tenedorIzquierda, Tenedor tenedorDerecha) {
        super(String.format("Filosofo -%d", number));
        _cenaFilosofos = cenaFilosofos;
        _tenedorIzquierda = tenedorIzquierda;
        _tenedorDerecha = tenedorDerecha;
    }

    private void randomSleep() throws InterruptedException {
        Thread.sleep(1000 + (int) Math.random()*2000);
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {

        try {
            // Meditar
            System.out.printf("%s Meditando %n", getName());
            randomSleep();

            // Intentan coger tenedor
            System.out.printf("%s intenta coger los tenedores %n", getName());
            _cenaFilosofos.cojerTenedor(_tenedorIzquierda, _tenedorDerecha);

            // Comer
            System.out.printf("%s cenando %n", getName());
            randomSleep();

            // Dejar los tenedores
            System.out.printf("%s ha dejado los tenedores %n", getName());
            _cenaFilosofos.dejarTenedores(_tenedorIzquierda, _tenedorDerecha);

        } catch (InterruptedException e) {
            break;
        }

        }
    }
}
