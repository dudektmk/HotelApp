package com.luxoft.service;

import com.luxoft.model.Hotel;

import java.util.Set;

/**
 * Created by Dudi on 2015-02-09.
 */
public interface HotelService {
   public void addReservation(Hotel hotel, String reservation);
    void printReservations(Hotel hotel);
    Set<String> getReservations(Hotel hotel);
    void cancelReservation(Hotel hotel, String roomId);
}
