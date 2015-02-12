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

        req.setAttribute("roomError", Validator.validateAndAddIfOk(req.getParameter("roomId"),req.getParameter("clientName"), roomReservationsService));
        req.setAttribute("bookedRooms", roomReservationsService.getReservations());
        req.getRequestDispatcher("/reservation").forward(req, resp);
    }
}
