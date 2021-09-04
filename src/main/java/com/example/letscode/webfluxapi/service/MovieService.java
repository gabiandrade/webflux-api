package com.example.letscode.webfluxapi.service;

import com.example.letscode.webfluxapi.config.RetrofitFactoryInstance;
import com.example.letscode.webfluxapi.config.service.RetrofitMovieService;
import com.example.letscode.webfluxapi.constants.ConstantsCore;
import com.example.letscode.webfluxapi.domain.MoviesList;
import com.example.letscode.webfluxapi.domain.v2.MoviesDetails;
import com.example.letscode.webfluxapi.webclient.MoviesWebClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class MovieService {

    private static final Logger log = LoggerFactory.getLogger(MovieService.class);

    //Contador do processo da thread
    private static Integer PROCESS_COUNTER = 0;

    @Autowired
    private final MoviesWebClient moviesWebClient;

    public MovieService(MoviesWebClient moviesWebClient) {
        this.moviesWebClient = moviesWebClient;
    }

    public Flux<MoviesList> getMoviesPopular() {
        return RetrofitFactoryInstance.getFactoryInstanceRetrofit(false).create(RetrofitMovieService.class)
                .getMoviesPopular(ConstantsCore.API_KEY);
    }

    /*Método que faz a chamada ao endpoint do webflux-api-sync.jar */
    /* Assim que a thread é iniciada o metodo doFirst é chamado e printa o inicio do evento */
    /* Quando o fluxo de eventos é finalizado com sucesso é retornado o objeto de detalhes do filme
     e exibido o log finally thread*/
    public Mono<MoviesDetails> getMoviesDetails(Integer id) {
        return RetrofitFactoryInstance.getFactoryInstanceRetrofit(true).
                create(RetrofitMovieService.class).getDetailMoviePopularSync(id)
                .doFirst(MovieService::initEvent)
                .doOnSuccess(MovieService::finallyEvent);
    }

    private static void initEvent() {
        PROCESS_COUNTER += 1;
        log.info("Init Thread Proccess Started: {} ", PROCESS_COUNTER);
    }

    private static void finallyEvent(MoviesDetails moviesDetails) {
        log.info("Finally Thread Process SuccessEvent: {} - idMovie - {}", PROCESS_COUNTER, moviesDetails.getId());
    }

    /*Método da chamada do WebClient que vai na api do The movie DB*/
    public Flux<String> getMoviesPopularWithWebClient() {
        return this.moviesWebClient.getWebClient().get().uri("movies").accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(MoviesList.class)
                .map(MoviesList::getItemCount);
    }

}
