package com.travelapp.retrofitregistrationsql;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static Retrofit retrofit = null;
    private static RetrofitAPI retrofitAPI;

    public static synchronized  RetrofitAPI getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl("https://trigonous.000webhostapp.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
            retrofitAPI = retrofit.create(RetrofitAPI.class);
        }
        return retrofitAPI;
    }
}
