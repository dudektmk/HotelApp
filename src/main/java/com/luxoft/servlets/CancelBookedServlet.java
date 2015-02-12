package com.luxoft.servlets;

import com.luxoft.service.RoomReservationsService;
import com.luxoft.service.RoomReservationsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Dudi on 2015-02-09.
 */
public class CancelBookedServlet extends HttpServlet {

    //@Autowired
    private RoomReservationsService roomReservationsService = RoomReservationsServiceImpl.getInstance();

    @Override
    protected void doPost (HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        cancelReservation((String) req.getParameter("roomId"));
        req.setAttribute("bookedRooms", roomReservationsService.getReservations());
        req.getRequestDispatcher("/reservation").forward(req, resp);
    }

    private void cancelReservation(String roomId) {
        roomReservationsService.cancelReservationFromDb(roomId);
        roomReservationsService.cancelReservation(roomId);
    }
}
