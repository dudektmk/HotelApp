package com.luxoft.servlets;




import com.luxoft.exceptions.ReservationExistsException;
import com.luxoft.service.RoomReservationsService;
import com.luxoft.service.RoomReservationsServiceImpl;
import com.luxoft.validator.Validator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Dudi on 2015-02-09.
 */
public class AddBookedServlet extends HttpServlet {

    //@Autowired
    private RoomReservationsService roomReservationsService= RoomReservationsServiceImpl.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        if (Validator.validateRoomId(req.getParameter("roomId"))) {
            try {
                roomReservationsService.addReservation((String)req.getParameter("roomId"));
            } catch (ReservationExistsException e) {
                req.setAttribute("roomError", "alreadyBooked");
            }
            req.setAttribute("bookedRooms", roomReservationsService.getReservations());
            req.getRequestDispatcher("/").forward(req, resp);
    } else {
        req.setAttribute("roomError", "wrongId");
        req.setAttribute("bookedRooms", roomReservationsService.getReservations());
        req.getRequestDispatcher("/").forward(req, resp);
        }
    }
}
