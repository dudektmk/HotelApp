package com.luxoft;

/**
 * Created by Dudi on 2015-02-09.
 */
import com.luxoft.model.Reservation;
import com.luxoft.model.ReservationRepository;
import com.luxoft.servlets.CancelAllBookedServlet;
import com.luxoft.servlets.CancelBookedServlet;
import com.luxoft.servlets.AddBookedServlet;
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
public class Application{

    public static void main(String[] args) {
        ConfigurableApplicationContext context=SpringApplication.run(Application.class, args);
        ReservationRepository repository = context.getBean(ReservationRepository.class);



        // fetch all customers
        Iterable<Reservation> reservations = repository.findAll();

        System.out.println("Reservations found with findAll():");
        System.out.println("-------------------------------");
        for (Reservation res : reservations) {
            System.out.println(res);
        }
        System.out.println();
        repository.save(new Reservation("room1.2", "Tomasz Dudek2"));
        repository.save(new Reservation("room2.2", "Pan Kleks2"));

        // fetch all customers
        Iterable<Reservation> reservations2 = repository.findAll();
        System.out.println("Reservations found with findAll():");
        System.out.println("-------------------------------");
        for (Reservation res : reservations2) {
            System.out.println(res);
        }
        System.out.println();
    }

    @Bean
    public ServletRegistrationBean registerGetBookedServlet(){
        return new ServletRegistrationBean(new AddBookedServlet(),"/addBooked");
    }
    @Bean
    public ServletRegistrationBean registerCancelBookedServlet(){
        return new ServletRegistrationBean(new CancelBookedServlet(),"/cancelBooked");
    }
    @Bean
    public ServletRegistrationBean registerCancelAllBookedServlet(){
        return new ServletRegistrationBean(new CancelAllBookedServlet(),"/cancelAll");
    }
}
