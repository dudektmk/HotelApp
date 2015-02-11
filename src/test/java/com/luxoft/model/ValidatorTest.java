//package com.luxoft.model;
//
//import com.luxoft.service.RoomReservationsService;
//import com.luxoft.service.RoomReservationsServiceImpl;
//import com.luxoft.validator.Validator;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//
///**
// * Created by tdudek on 2015-02-11.
// */
//public class ValidatorTest {
//
//    private RoomReservationsService roomReservationsService=RoomReservationsServiceImpl.getInstance();;
//
//    @Before
//    public void init(){
//        roomReservationsService.cancelAll();
//    }
//    @Test
//    public void shouldReturnEmptyIdWhenNoImputProvided() throws Exception {
//        Assert.assertEquals("emptyId", Validator.validateAndAddIfOk("", roomReservationsService));
//    }
//
//    @Test
//    public void shouldReturnWrongIdWhenNoProperInput() throws Exception {
//        Assert.assertEquals("wrongId", Validator.validateAndAddIfOk("!",roomReservationsService));
//    }
//    @Test
//    public void shouldReturnAlreadyBookedWhenTryingToDuplicateReservation() throws Exception {
//        roomReservationsService.addReservation("room1");
//        Assert.assertEquals("alreadyBooked", Validator.validateAndAddIfOk("room1",roomReservationsService));
//    }
//    @Test
//    public void shouldReturnEmptyStringWhenProperInput() throws Exception {
//        Assert.assertEquals("", Validator.validateAndAddIfOk("room1",roomReservationsService));
//    }
//}
