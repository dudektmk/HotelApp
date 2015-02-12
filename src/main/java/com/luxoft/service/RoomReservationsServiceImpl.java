package com.luxoft.service;

import com.luxoft.Application;
import com.luxoft.exceptions.ReservationExistsException;
import com.luxoft.model.Reservation;
import com.luxoft.model.RoomReservations;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by Dudi on 2015-02-09.
 */
@Service
public class RoomReservationsServiceImpl implements RoomReservationsService {

    private RoomReservations roomReservations;
    private static final RoomReservationsServiceImpl singletonInstance=new RoomReservationsServiceImpl();

    private RoomReservationsServiceImpl() {
        this.roomReservations=new RoomReservations();
    }

    @Override
    public void addReservation(Reservation reservation) throws ReservationExistsException{
        roomReservations.addReservation(reservation);
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

    @Override
    public void addReservationToDb(Reservation reservation) {
        Application.repository.save(reservation);
    }

    @Override
    public void cancelReservationFromDb(String roomId) {
        for (Reservation res : roomReservations.getReservations()) {
            if(res.getRoomId().equals(roomId))
            Application.repository.delete(res);
        }
    }
    @Override
    public void cancelAllReservationsFromDb() {
        Application.repository.deleteAll();
    }

    public static RoomReservationsServiceImpl getInstance(){
        return singletonInstance;
    }
}
