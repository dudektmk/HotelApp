package com.luxoft.service;

import com.luxoft.exceptions.ReservationExistsException;
import com.luxoft.model.Reservation;

import java.util.Set;

/**
 * Created by Dudi on 2015-02-09.
 */
public interface RoomReservationsService {
    void addReservation(Reservation reservation) throws ReservationExistsException;
    void printReservations();
    Set<Reservation> getReservations();
    void cancelReservation(String roomId);
    void cancelAll();
    void addReservationToDb(Reservation reservation);
    void cancelReservationFromDb(String roomId);
    void cancelAllReservationsFromDb();
}
