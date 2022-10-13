package com.example.monitoringsiswapkl.api;

import static com.example.monitoringsiswapkl.utils.Config.BASEURL;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiServer {
    private static Retrofit retrofit;
    public static Retrofit getClient()
    {
        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASEURL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

}
