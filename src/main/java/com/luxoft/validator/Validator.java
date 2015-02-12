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
                Reservation reservtion=new Reservation(roomId,clientName);
                roomReservationsService.addReservation(reservtion);
            } catch (ReservationExistsException e) {
                return "alreadyBooked";
            }
        return "";
}


}
