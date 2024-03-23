package com.example.demopro;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface WebServices {

    @POST("RegisterUser/Registeruser")
    Call<RegisterModel> RegisterUser(@Body RegisterModel registerModel);

    @POST("RegisterUser/Registeruser")
    Call<RegNewModel> RegisterNewUser(@Body RegNewModel RegNewModel);

    @POST("RegisterUser/id")
    Call<DeleteResponce> DELETE_RESPONCE_CALL(@Body DeleteResponce responce);

    @GET("RegisterUser/Registeruser")
    Call<List<RegNewModel>> GetRegisterUser();
}
