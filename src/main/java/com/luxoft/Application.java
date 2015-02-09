package com.luxoft;

/**
 * Created by Dudi on 2015-02-09.
 */
import com.luxoft.servlets.CancelBookedServlet;
import com.luxoft.servlets.GetBookedServlet;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@EnableAutoConfiguration
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public ServletRegistrationBean registerGetBookedServlet(){
        return new ServletRegistrationBean(new GetBookedServlet(),"/getBooked");
    }
    @Bean
    public ServletRegistrationBean registerCancelBookedServlet(){
        return new ServletRegistrationBean(new CancelBookedServlet(),"/cancel");
    }
}
