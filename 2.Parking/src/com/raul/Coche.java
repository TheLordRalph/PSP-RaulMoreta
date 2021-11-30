package com.raul;

public class Coche extends Thread {

    private final Parking _parking;
    public String _matricula;

    public Coche(Parking parking, String name) {
        super(name);
        _parking = parking;
    }

    @Override
    public void run() {
        super.run();
        while (true) {
            try {
                Thread.sleep((int)(Math.random()*2000));
                _parking.ocuparPlaza(this);
                Thread.sleep((int)(Math.random()*2000));
                _parking.dejarPlaza(this);
            } catch (InterruptedException e) {
                System.out.printf("coche %s ha muerto %n", getName());
                break;
            }
        }
    }
}
