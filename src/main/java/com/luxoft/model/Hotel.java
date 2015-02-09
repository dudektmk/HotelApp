package com.luxoft.model;

import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * Created by Dudi on 2015-02-09.
 */
public class Hotel {
    private Set<String> reservations;

    public Hotel(Set bookedRooms){
        this.reservations=bookedRooms;
    }

    public Set<String> getReservations() {
        return reservations;
    }
}
