package com.raul;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        CenaFilosofos cenaFilosofos = new CenaFilosofos();


        List<Tenedor> tenedores = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            tenedores.add(new Tenedor());
        }


        List<Filosofo> filosofos = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            filosofos.add(new Filosofo(i, cenaFilosofos, tenedores.get(i), tenedores.get((i+1)% tenedores.size())));
        }

        for (Filosofo filosofo : filosofos) {
            filosofo.start();
        }

    }
}
