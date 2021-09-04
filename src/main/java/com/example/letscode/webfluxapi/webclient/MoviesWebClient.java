package com.example.letscode.webfluxapi.webclient;


import com.example.letscode.webfluxapi.constants.ConstantsCore;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class MoviesWebClient {

    private final WebClient webClient;

    public MoviesWebClient(WebClient.Builder webClient) {
        this.webClient = webClient.baseUrl(ConstantsCore.BASE_URL_LOCAL).build();
    }

    public WebClient getWebClient() {
        return webClient;
    }
}