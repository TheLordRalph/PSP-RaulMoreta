package com.raul;

public class Shop {

    private int _femaleLockers;
    private int _maleLockers;

    private int _femaleLockersOccupancy = 0;
    private int _maleLockersOccupancy = 0;

    public Shop(int femaleLockers, int maleLockers) {
        _femaleLockers = femaleLockers;
        _maleLockers = maleLockers;
    }


    public synchronized void enterFemale(Customer customer) throws InterruptedException {
        while (_femaleLockersOccupancy >= _femaleLockers) {
            System.out.printf("Client %s waiting for available female locker %n", customer.getName());
            wait();
        }
        _femaleLockersOccupancy++;
        System.out.printf("Client %s got a locker there's %d available male lockers %n", customer.getName(), (_femaleLockers - _femaleLockersOccupancy));
        notifyAll();
    }

    public synchronized void enterMale(Customer customer) throws InterruptedException {
        while (_maleLockersOccupancy >= _maleLockers) {
            System.out.printf("Client %s waiting for available male locker %n", customer.getName());
            wait();
        }
        _maleLockersOccupancy++;
        System.out.printf("Client %s got a locker there's %d available male lockers %n", customer.getName(), (_maleLockers - _maleLockersOccupancy));
        notifyAll();
    }



    public synchronized void leaveFemale(Customer customer) {
        _femaleLockersOccupancy--;
        System.out.printf("Client %s leaving locker, there's %d available male lockers %n", customer.getName(), (_femaleLockers - _femaleLockersOccupancy));
        notifyAll();
    }

    public synchronized void leaveMale(Customer customer) {
        _maleLockersOccupancy--;
        System.out.printf("Client %s leaving locker, there's %d available male lockers %n", customer.getName(), (_maleLockers - _maleLockersOccupancy));
        notifyAll();
    }


}
