package com.luxoft.model;

import com.luxoft.exceptions.ReservationExistsException;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;


public class RoomReservations {

    private Set<String> reservations;
    private UUID reservationID;

    public RoomReservations() {
        this.reservations = new HashSet<String>();
        reservationID=UUID.randomUUID();
    }

    public Set<String> getReservations() {
        return reservations;
    }

    public void addReservation(String s) throws ReservationExistsException{
        for(String res:reservations){
            if(res.equals(s)){
                throw new ReservationExistsException("Room is already reserved");
            }
        }
        reservations.add(s);
    }

    public void cancelReservation(String s) {
        reservations.remove(s);
    }

    @Override
    public String toString() {
        return "RoomReservations{" +
                "reservations=" + reservations +
                ", reservationID=" + reservationID +
                '}';
    }

    public void cancelAll() {
        reservations.clear();
    }
}
