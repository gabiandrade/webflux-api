package com.example.letscode.webfluxapi.config;

import com.example.letscode.webfluxapi.constants.ConstantsCore;
import com.jakewharton.retrofit2.adapter.reactor.ReactorCallAdapterFactory;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;

public class RetrofitInitializer {

    private static Retrofit retrofitInstance;

    public static Retrofit getRetrofit() {
        if(retrofitInstance == null ) {
            retrofitInstance = new Retrofit.Builder().baseUrl(ConstantsCore.BASE_URL).
                    addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(ReactorCallAdapterFactory.create()).build();
        }
        return retrofitInstance;
    }
}
