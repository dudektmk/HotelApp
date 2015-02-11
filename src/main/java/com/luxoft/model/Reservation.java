package com.luxoft.model;

import java.util.UUID;

/**
 * Created by tdudek on 2015-02-11.
 */
public class Reservation {
    private String roomId;
    private String reservationId;

    public Reservation(String roomId) {
        this.roomId=roomId;
        this.reservationId=generateId();
    }

    private String generateId() {
        String reservationID = UUID.randomUUID().toString();
        return reservationID.substring(reservationID.length() - 8);
    }

    public String getReservationId() {
        return reservationId;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }


}
