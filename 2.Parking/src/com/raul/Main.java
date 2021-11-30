package com.raul;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Parking parking = new Parking(3);

        Coche coche1 = new Coche(parking, "M4878VX");
        Coche coche2 = new Coche(parking, "2345MZX");
        Coche coche3 = new Coche(parking, "1234ZZO");
        Coche coche4 = new Coche(parking, "8493FCS");
        Coche coche5 = new Coche(parking, "0012AAE");

        coche1.start();
        coche2.start();
        coche3.start();
        coche4.start();
        coche5.start();

        Thread.sleep((int) (Math.random()*10000));
        coche1.interrupt();
        coche2.interrupt();
        coche3.interrupt();
        coche4.interrupt();
        coche5.interrupt();


        coche1.join();
        coche2.join();
        coche3.join();
        coche4.join();
        coche5.join();

        System.out.println("El parking ha cerrado");
    }
}
