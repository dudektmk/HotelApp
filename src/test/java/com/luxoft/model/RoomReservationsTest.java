package com.luxoft.model;


import org.junit.Assert;
import org.junit.Test;
import static org.assertj.core.api.Assertions.*;
import java.util.Set;

/**
* Created by tdudek on 2015-02-10.
*/

public class RoomReservationsTest {

    private final RoomReservations roomReservations = new RoomReservations();

    @Test
    public void shouldReturnEmptyListOfReservationsOnStart() throws Exception {

        Set<Reservation> result= roomReservations.getReservations();

        assertThat(result).isEmpty();
    }

    @Test
    public void shouldReturnSetWithOneReservationWhenOneWasAdded() throws Exception {
        Reservation reservation=new Reservation("room 1", "guestName");
        roomReservations.addReservation(reservation);
        Set<Reservation> result= roomReservations.getReservations();

        assertThat(result).hasSize(1);
    }

    @Test
    public void shouldReturnEmptySetWhenThereIsNoReservations() throws Exception {
        Reservation reservation=new Reservation("room 1", "guestName");
        roomReservations.addReservation(reservation);
        roomReservations.cancelReservation("room 1");
        Set<Reservation> result= roomReservations.getReservations();

        assertThat(result).isEmpty();
    }

    @Test
    public void shouldReturnSetWithOneReservation() throws Exception {
        Reservation reservation=new Reservation("room 1", "guestName");
        roomReservations.addReservation(reservation);

        roomReservations.cancelReservation("room 2");

        Set<Reservation> result= roomReservations.getReservations();

        assertThat(result).hasSize(1);
    }

    @Test
    public void shouldReturnEmptySetWhenAllReservationsWasCanceled() throws Exception {
        Reservation reservation1=new Reservation("room 1", "guestName");
        Reservation reservation2=new Reservation("room 2", "guestName");
        roomReservations.addReservation(reservation1);
        roomReservations.addReservation(reservation2);


        roomReservations.cancelAll();
        Set<Reservation> result= roomReservations.getReservations();

        assertThat(result).isEmpty();
    }
}

