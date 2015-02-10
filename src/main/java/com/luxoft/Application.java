package com.luxoft;

/**
 * Created by Dudi on 2015-02-09.
 */
import com.luxoft.servlets.CancelAllBookedServlet;
import com.luxoft.servlets.CancelBookedServlet;
import com.luxoft.servlets.AddBookedServlet;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@ComponentScan
@EnableAutoConfiguration
public class Application{

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
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
