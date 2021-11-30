package com.raul;

/* Mis codigos son solo y exclusivos para el Castellano
*  Yo no escribo en Ingles */

public class Parking {

    private  final int _plazasTotales;
    private int _plazasDisponibles;

    public Parking(int plazasTotales) {
        _plazasTotales = plazasTotales;
        _plazasDisponibles = _plazasTotales;
    }

    public synchronized void ocuparPlaza(Coche coche) {
        while (_plazasDisponibles == 0) {
            try {
                System.out.printf("Coche %s esperando plaza vacida %n", coche.getName());
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }

        _plazasDisponibles--;
        System.out.printf("Coche %s acaba de aparcar, quedan %d plazas disponibles %n", coche.getName(), _plazasDisponibles);
        notifyAll();
    }

    public synchronized void dejarPlaza(Coche coche) {
        _plazasDisponibles++;
        System.out.printf("Coche %s se acaba de dejar la plaza, quedan %d plazas disponibles %n", coche.getName(), _plazasDisponibles);
        notifyAll();
    }
}
