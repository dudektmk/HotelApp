package com.luxoft.servlets;

/**
 * Created by tdudek on 2015-02-12.
 */

import com.luxoft.service.RoomReservationsService;
import com.luxoft.service.RoomReservationsServiceImpl;
import com.luxoft.validator.Validator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class InitFromDbServlet extends HttpServlet {

    //@Autowired
    private RoomReservationsService roomReservationsService= RoomReservationsServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setAttribute("bookedRooms", roomReservationsService.getReservations());
        req.getRequestDispatcher("/reservation").forward(req, resp);
    }
}

