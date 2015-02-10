package com.luxoft.service;

import com.luxoft.model.RoomReservations;

import java.util.Set;

/**
 * Created by Dudi on 2015-02-09.
 */
public interface RoomReservationsService {
    void addReservation(String reservation);
    void printReservations();
    Set<String> getReservations();
    void cancelReservation(String roomId);
}
