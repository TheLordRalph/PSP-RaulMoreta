package com.raul;

public interface Observer {

    default void update(Observable o, Object arg) {
    }
}
