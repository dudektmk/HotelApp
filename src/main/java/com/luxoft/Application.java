package com.luxoft;

/**
 * Created by Dudi on 2015-02-09.
 */
import com.luxoft.exceptions.ReservationExistsException;
import com.luxoft.model.Reservation;
import com.luxoft.model.ReservationRepository;
import com.luxoft.service.RoomReservationsService;
import com.luxoft.service.RoomReservationsServiceImpl;
import com.luxoft.servlets.CancelAllBookedServlet;
import com.luxoft.servlets.CancelBookedServlet;
import com.luxoft.servlets.AddBookedServlet;
import com.luxoft.servlets.InitFromDbServlet;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@ComponentScan
@EnableAutoConfiguration
public class Application {
    private static RoomReservationsService roomReservationsService = RoomReservationsServiceImpl.getInstance();
    public static ReservationRepository repository;

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
        repository=context.getBean(ReservationRepository.class);

        // fetch all customers
        Iterable<Reservation> reservations = repository.findAll();
        for (Reservation res : reservations) {
            try {
                roomReservationsService.addReservation(res);
            } catch (ReservationExistsException e) {
                System.out.println(e.getName());
            }
        }

    }

    @Bean
    public ServletRegistrationBean registerGetBookedServlet() {
        return new ServletRegistrationBean(new AddBookedServlet(), "/addBooked");
    }

    @Bean
    public ServletRegistrationBean registerCancelBookedServlet() {
        return new ServletRegistrationBean(new CancelBookedServlet(), "/cancelBooked");
    }

    @Bean
    public ServletRegistrationBean registerCancelAllBookedServlet() {
        return new ServletRegistrationBean(new CancelAllBookedServlet(), "/cancelAll");
    }

    @Bean
    public ServletRegistrationBean registerInitFromDbServlet() {
        return new ServletRegistrationBean(new InitFromDbServlet(), "/initServlet");
    }
}
