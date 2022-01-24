package com.raul;

public abstract class Customer extends Thread {

    private FemaleCustomer _femaleCustomer;
    private MaleCustomer _memaleCustomer;

    public static int _SLOW_CLIENT_TIMEOUT = 2000 + (int) (Math.random() * 4000);
    public static int _FAST_CLIENT_TIMEOUT = (int) (Math.random() * 4000);

    protected Customer(String name, FemaleCustomer femaleCustomer) {
        super(name);
        _femaleCustomer = femaleCustomer;
    }

    protected Customer(String name, MaleCustomer MemaleCustomer) {
        super(name);
        _memaleCustomer = MemaleCustomer;
    }

    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(_SLOW_CLIENT_TIMEOUT);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }
}
