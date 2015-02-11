package com.luxoft.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;

/**
 * Created by tdudek on 2015-02-11.
 */
@Entity
public class Reservation implements Comparable{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private String clientName;
    private String roomId;
    private String reservationId;

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public Reservation() {
    }

    public Reservation(String roomId, String clientName) {
        this.roomId=roomId;
        this.clientName=clientName;
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

    @Override
    public int compareTo(Object o) {
        return this.roomId.compareTo(((Reservation)o).getRoomId());
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", clientName='" + clientName + '\'' +
                ", roomId='" + roomId + '\'' +
                ", reservationId='" + reservationId + '\'' +
                '}';
    }
}
