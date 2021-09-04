package com.example.letscode.webfluxapi;

import com.example.letscode.webfluxapi.service.MovieService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class WebfluxApiApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(WebfluxApiApplication.class, args);

        // Requisição feita através do WebClient.
        System.err.println(context.getBean(MovieService.class).getMoviesPopularWithWebClient().blockFirst());
    }
}
