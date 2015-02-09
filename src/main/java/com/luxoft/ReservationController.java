package com.luxoft;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Created by Dudi on 2015-02-09.
 */
@Controller
public class ReservationController {
    @RequestMapping("/")
    public String reservation() {
        return "reservation";
    }
}
