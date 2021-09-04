package com.example.letscode.webfluxapi.config;

import com.example.letscode.webfluxapi.constants.ConstantsCore;
import com.jakewharton.retrofit2.adapter.reactor.ReactorCallAdapterFactory;
import okhttp3.OkHttpClient;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;

import java.util.concurrent.TimeUnit;

public class RetrofitInitializer {

    /* Para o exemplo do webflux-api-sync.jar foi aumentado
     * o tempo de timeout do socket do retrofit para 30 seconds
     * ja que o default era menos que 30 e nosso exemplo demandaria
     * de mais de 20 seconds.
     * */
    public static Retrofit getRetrofit(Boolean isLocal) {
        OkHttpClient client = new OkHttpClient.Builder()
                .readTimeout(30, TimeUnit.SECONDS)
                .connectTimeout(30, TimeUnit.SECONDS)
                .build();
        return new Retrofit.Builder().baseUrl(isLocal ?
                        ConstantsCore.BASE_URL_LOCAL_SYNC :
                        ConstantsCore.BASE_URL).
                addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .addCallAdapterFactory(ReactorCallAdapterFactory.create()).build();
    }
}
