package com.luxoft;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * Created by Dudi on 2015-02-09.
 */
@Controller
public class ReservationController {
    @RequestMapping(value = "/")
    public String reservation() {
        return "reservation";
    }
}
