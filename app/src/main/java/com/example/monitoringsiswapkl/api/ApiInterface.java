package com.example.monitoringsiswapkl.api;

import com.example.monitoringsiswapkl.model.ResponseLogin;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterface {
    @FormUrlEncoded
    @POST("api/authentication/login")
    Call<ResponseLogin> login(
        @Field("username") String username,
        @Field("password") String password
    );

}
