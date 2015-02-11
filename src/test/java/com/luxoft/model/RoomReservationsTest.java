package com.luxoft.model;


import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;

/**
 * Created by tdudek on 2015-02-10.
 */

public class RoomReservationsTest {

    private final RoomReservations roomReservations = new RoomReservations();

    @Test
    public void shouldReturnEmptyListOfReservationsOnStart() throws Exception {

        Set<Reservation> result= roomReservations.getReservations();

        Assert.assertTrue(result.isEmpty());
    }

    @Test
    public void shouldReturnSetWithOneReservationWhenOneWasAdded() throws Exception {
        roomReservations.addReservation("room 1");
        Set<Reservation> result= roomReservations.getReservations();
        Assert.assertEquals(1,result.size());
    }

    @Test
    public void shouldReturnEmptySetWhenThereIsNoReservations() throws Exception {
        roomReservations.addReservation("room 1");
        roomReservations.cancelReservation("room 1");
        Set<Reservation> result= roomReservations.getReservations();

        Assert.assertTrue(result.isEmpty());
    }

    @Test
    public void shouldReturnSetWithOneReservation() throws Exception {
        roomReservations.addReservation("room 1");

        roomReservations.cancelReservation("room 2");

        Set<Reservation> result= roomReservations.getReservations();

        Assert.assertEquals(1,result.size());
        Assert.assertThat(result.size(), equalTo(1));
    }

    @Test
    public void shouldReturnEmptySetWhenAllReservationsWasCanceled() throws Exception {
        roomReservations.addReservation("room 1");
        roomReservations.addReservation("room 2");

        roomReservations.cancelAll();
        Set<Reservation> result= roomReservations.getReservations();

        Assert.assertTrue(result.isEmpty());
    }

//    @Test
//    public void shouldReturn8digitId() throws Exception {
//        Assert.assertEquals(8, roomReservations.getReservationID().length());
//    }
//
//    @Test
//    public void shouldReturnsUniqueIds() throws Exception {
//        Set<RoomReservations> uniqueReservations = new HashSet<RoomReservations>();
//        for(int i=0; i<10000;i++){
//            uniqueReservations.add(new RoomReservations());
//        }
//        Assert.assertEquals(10000, uniqueReservations.size());
//    }
}

