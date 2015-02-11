package com.luxoft.model;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
* Created by tdudek on 2015-02-11.
*/
public class ReservationTest {
    @Test
    public void shouldReturn8digitId() throws Exception {
        Reservation res=new Reservation("resName","guestName");

        Assert.assertEquals(8, res.getReservationId().length());
    }

    @Test
    public void shouldReturnsUniqueIds() throws Exception {
        Set<Reservation> uniqueReservations = new HashSet<Reservation>();
        for(int i=0; i<10000;i++){
            uniqueReservations.add(new Reservation("resName", "guestName"));
        }
        Assert.assertEquals(10000, uniqueReservations.size());
    }
}
