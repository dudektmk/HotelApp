package com.luxoft.model;

import com.luxoft.service.RoomReservationsService;
import com.luxoft.service.RoomReservationsServiceImpl;
import com.luxoft.validator.Validator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.verify;

/**
 * Created by tdudek on 2015-02-11.
 */
@RunWith(MockitoJUnitRunner.class)
public class ValidatorTest {

    private RoomReservationsService
            roomReservationsService=RoomReservationsServiceImpl.getInstance();
    @Mock RoomReservationsService reservationsServiceMock;

    @Before
    public void init(){
        roomReservationsService.cancelAll();
    }
    @Test
    public void shouldReturnEmptyIdWhenNoImputProvided() throws Exception {

        assertThat(Validator.validateAndAddIfOk("","guestName",roomReservationsService)).isEqualTo("emptyId");
    }
    @Test
    public void shouldReturnEmptyNameWhenNoNameProvided() throws
            Exception {

        assertThat(Validator.validateAndAddIfOk("room1","",roomReservationsService)).isEqualTo("emptyName");
    }
    @Test
    public void shouldReturnWrongIdWhenNoProperInput() throws
            Exception {

        assertThat(Validator.validateAndAddIfOk("ś","guestName",roomReservationsService)).isEqualTo("wrongId");
    }
    @Test
    public void
    shouldReturnAlreadyBookedWhenTryingToDuplicateReservation() throws
            Exception {
        roomReservationsService.addReservation(new
                Reservation("room1", "guestName"));

        assertThat(Validator.validateAndAddIfOk("room1","guestName",roomReservationsService)).isEqualTo("alreadyBooked");
    }
    @Test
    public void shouldReturnEmptyStringWhenProperInput() throws
            Exception {


        assertThat(Validator.validateAndAddIfOk("room1", "guestName", reservationsServiceMock)).isEqualTo("");
        verify(reservationsServiceMock).addReservation((Reservation) anyObject());
        verify(reservationsServiceMock).addReservationToDb((Reservation) anyObject());
    }
}
