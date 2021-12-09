package com.raul;

public class Client extends Thread {

    private String _nombre;
    private Broker _broker;
    private int _numeroAccionesParaComprar;
    private int _totalAcciones = 0;

    public Client (String nombre, Broker broker) {
        _nombre = nombre;
        _broker = broker;
    }

    @Override
    public void run() {
        super.run();
        while (true) {
            try {
                Thread.sleep((long) (Math.random() * 2000));

                _numeroAccionesParaComprar = (int) (Math.random() * 4) + 1;
                System.out.printf("Client %s about to buy %d shares %n", _nombre, _numeroAccionesParaComprar);
                if (_broker.buy(_numeroAccionesParaComprar)) {
                    System.out.printf("Client %s bought %d shares %n", _nombre, _numeroAccionesParaComprar);
                    _totalAcciones += _numeroAccionesParaComprar;
                } else {
                    System.out.printf("Client %s couldn't buy %d shares %n", _nombre, _numeroAccionesParaComprar);
                }
            } catch(InterruptedException e){
                break;
            }
        }
        System.out.printf("Client %s bought %d shares in total %n", _nombre, _totalAcciones);
    }
}
