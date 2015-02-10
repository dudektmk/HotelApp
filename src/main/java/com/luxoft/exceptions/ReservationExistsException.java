package com.luxoft.exceptions;

/**
 * Created by Dudi on 2015-02-10.
 */
public class ReservationExistsException extends Exception{
    private String name;

    public ReservationExistsException(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
