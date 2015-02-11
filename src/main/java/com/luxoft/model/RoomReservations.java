package com.luxoft.model;

import com.luxoft.exceptions.ReservationExistsException;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;


public class RoomReservations {

    private Set<String> reservations;

    private String reservationID;

    public RoomReservations() {
        this.reservations = new HashSet<String>();
        reservationID=generateId();
    }

    public void setReservationID(String reservationID) {
        this.reservationID = reservationID;
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

    private String generateId(){
        String reservationID= UUID.randomUUID().toString();
        return reservationID.substring(reservationID.length()-8);
    }

    public String getReservationID() {
        return reservationID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoomReservations that = (RoomReservations) o;

        if (!reservationID.equals(that.reservationID)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return reservationID.hashCode();
    }
}
