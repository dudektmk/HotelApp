package com.luxoft.service;

import com.luxoft.exceptions.ReservationExistsException;
import com.luxoft.model.Reservation;
import com.luxoft.model.RoomReservations;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by Dudi on 2015-02-09.
 */
@Service
public class RoomReservationsServiceImpl implements RoomReservationsService {

    private RoomReservations roomReservations;
    private static RoomReservationsServiceImpl singletonInstance=new RoomReservationsServiceImpl();

    private RoomReservationsServiceImpl() {
        this.roomReservations=new RoomReservations();
    }

    @Override
    public void addReservation(String reservation, String clientName) throws ReservationExistsException{
        roomReservations.addReservation(reservation,clientName);
    }

    @Override
    public void printReservations() {
        System.out.println(roomReservations.getReservations().toString());
    }

    @Override
    public Set<Reservation> getReservations() {
        return roomReservations.getReservations();
    }

    @Override
    public void cancelReservation(String roomId) {
        roomReservations.cancelReservation(roomId);
    }

    @Override
    public void cancelAll() {
        roomReservations.cancelAll();
    }

    public static RoomReservationsServiceImpl getInstance(){
        return singletonInstance;
    }
}
