package com.luxoft.service;

import com.luxoft.model.Hotel;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Dudi on 2015-02-09.
 */
@Service
public class HotelServiceImpl implements HotelService {

    public static Hotel hotel = new Hotel(new HashSet<String>());

    @Override
    public void addReservation(Hotel hotel, String reservation) {
        hotel.getReservations().add(reservation);
    }

    @Override
    public void printReservations(Hotel hotel) {
        System.out.println(hotel.getReservations());
    }

    @Override
    public Set<String> getReservations(Hotel hotel) {
        return hotel.getReservations();
    }

    @Override
    public void cancelReservation(Hotel hotel, String roomId) {
        hotel.getReservations().remove(roomId);
    }
}
