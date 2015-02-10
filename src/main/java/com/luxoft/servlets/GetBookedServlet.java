package com.luxoft.servlets;

import com.luxoft.model.Hotel;
import com.luxoft.service.HotelService;
import com.luxoft.service.HotelServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashSet;

/**
 * Created by Dudi on 2015-02-09.
 */
public class GetBookedServlet extends HttpServlet {

    //@Autowired
    private HotelService hotelService=new HotelServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        hotelService.addReservation(HotelServiceImpl.hotel,(String)req.getParameter("roomId"));
        req.setAttribute("bookedRooms", hotelService.getReservations(HotelServiceImpl.hotel));
        req.getRequestDispatcher("/").forward(req, resp);
    }

//    public void setHotelService(HotelService hotelService) {
//        this.hotelService = hotelService;
//    }
}
