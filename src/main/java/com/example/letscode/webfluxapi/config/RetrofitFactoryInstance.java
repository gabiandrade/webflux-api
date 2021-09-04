package com.example.letscode.webfluxapi.config;

import retrofit2.Retrofit;

public class RetrofitFactoryInstance {

    /* Método responsável por inicializar corretamente a instância
     * do retrofit que nesta aula suporta as urls localhost:8085 e a
     * api do the movie db.
     * Este método é chamado no service
     */
    public static Retrofit getFactoryInstanceRetrofit(Boolean isLocal) {
        if (isLocal) {
            //webflux-api-sync 8085
            return RetrofitInitializer.getRetrofit(true);
        }
        // the movie db
        return RetrofitInitializer.getRetrofit(false);
    }
}
