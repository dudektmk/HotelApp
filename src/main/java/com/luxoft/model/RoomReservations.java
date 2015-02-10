package com.luxoft.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by tdudek on 2015-02-10.
 */
public class RoomReservations {

    private Set<String> reservations;

    public RoomReservations() {
        this.reservations = new HashSet<String>();
    }

    public Set<String> getReservations() {
        return reservations;
    }

    public void addReservation(String s) {
        reservations.add(s);
    }

    public void cancelReservation(String s) {
        reservations.remove(s);
    }
}
