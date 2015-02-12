package com.luxoft.model;

import com.luxoft.exceptions.ReservationExistsException;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class RoomReservations {

    private Set<Reservation> reservations;

    public RoomReservations() {
        this.reservations = new TreeSet<Reservation>();
    }

    public Set<Reservation> getReservations() {
        return reservations;
    }

    public void addReservation(String s, String clientName) throws ReservationExistsException {
        for (Reservation res : reservations) {
            if (res.getRoomId().equals(s)) {
                throw new ReservationExistsException("Room is already reserved");
            }
        }
        reservations.add(new Reservation(s,clientName));
    }

    public  void cancelReservation(String s) {
        Iterator<Reservation> iter = reservations.iterator();
        while(iter.hasNext()){
            Reservation r = iter.next();
            if( r.getRoomId().equals(s) )
            {
                iter.remove();
            }
        }
    }



    public void cancelAll() {
        reservations.clear();
    }
}
