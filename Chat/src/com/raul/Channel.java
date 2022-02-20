package com.raul;

import com.raul.Observable;

public class Channel extends Observable {
    @Override
    public void notifyObservers(Object arg) {
        setChanged();
        super.notifyObservers(arg);
    }
}
