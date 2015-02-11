package com.luxoft.validator;

import com.luxoft.exceptions.ReservationExistsException;
import com.luxoft.service.RoomReservationsService;

/**
 * Created by KGornicki on 2015-02-10.
 */
public  class Validator {

    public static String validateAndAddIfOk(Object obj, RoomReservationsService roomReservationsService){
        String roomId=(String) obj;
        if(roomId.isEmpty()){
            return "emptyId";
        }
        if (!roomId.matches("[\\w .]+") && roomId.trim().equals(roomId)){
            return "wrongId";
        }
        try {
                roomReservationsService.addReservation(roomId);
            } catch (ReservationExistsException e) {
                return "alreadyBooked";
            }
        return "";
}


}
