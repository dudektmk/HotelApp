package com.luxoft.validator;

import com.luxoft.exceptions.ReservationExistsException;
import com.luxoft.model.Reservation;
import com.luxoft.service.RoomReservationsService;

/**
 * Created by KGornicki on 2015-02-10.
 */
public  class Validator {

    public static String validateAndAddIfOk(Object obj, Object obj2, RoomReservationsService roomReservationsService){
        String roomId=(String) obj;
        String clientName = (String) obj2;

        if(roomId.isEmpty()){
            return "emptyId";
        }
        if (!roomId.matches("[\\w.]+")){
            return "wrongId";
        }
        if(clientName.isEmpty()){
            return "emptyName";
        }
        try {
            addReservation(roomReservationsService, new Reservation(roomId,clientName));
            } catch (ReservationExistsException e) {
                return "alreadyBooked";
            }
        return "";
}

    public static void addReservation(RoomReservationsService roomReservationsService, Reservation reservation) throws ReservationExistsException {
        roomReservationsService.addReservation(reservation);
        roomReservationsService.addReservationToDb(reservation);
    }


}
