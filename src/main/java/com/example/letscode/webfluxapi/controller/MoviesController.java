package com.example.letscode.webfluxapi.controller;

import com.example.letscode.webfluxapi.domain.MoviesList;
import com.example.letscode.webfluxapi.domain.v2.MoviesDetails;
import com.example.letscode.webfluxapi.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("movies")
public class MoviesController {

    @Autowired
    private MovieService movieService;

    @GetMapping
    public Flux<MoviesList> getMoviesPopular() {
        return movieService.getMoviesPopular();
    }

    /*Endpoint do webflux-api-sync.jar.
     * O exercício da aula segue esse exemplo.
     */
    @GetMapping("{id}")
    public Mono<MoviesDetails> getMoviesDetails(@PathVariable("id") Integer id) {
        return movieService.getMoviesDetails(id);
    }
}