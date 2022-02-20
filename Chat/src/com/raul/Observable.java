package com.raul;

import java.util.Vector;

public class Observable {
    private boolean changed = false;
    protected Vector<Observer> obs;

    public Observable() {
        obs = new Vector<>();
    }

    public synchronized void addObserver(Observer o) {
        if (o == null)
            throw new NullPointerException();
        if (!obs.contains(o)) {
            obs.addElement(o);
        }
    }

    public void notifyObservers(Object arg) {
        Object[] arrLocal;

        synchronized (this) {
            if (!changed)
                return;
            arrLocal = obs.toArray();
            clearChanged();
        }

        for (int i = arrLocal.length-1; i>=0; i--)
            ((Observer)arrLocal[i]).update(this, arg);
    }

    public void notifyObserver(Object arg, String name) {
        Object[] arrLocal;
        setChanged();

        synchronized (this) {
            if (!changed)
                return;
            arrLocal = obs.toArray();
            clearChanged();
        }
        PeerConnection peerConnection;

        for (int i = arrLocal.length-1; i>=0; i--) {
            peerConnection = (PeerConnection) arrLocal[i];
            if (peerConnection.nickname.equals(name)) {
                ((PeerConnection) arrLocal[i]).update(this, arg);
            }
        }
    }

    protected synchronized void clearChanged() {
        changed = false;
    }

    protected synchronized void setChanged() {
        changed = true;
    }

    public synchronized void deleteObserver(Observer o) {
        obs.removeElement(o);
    }
}
