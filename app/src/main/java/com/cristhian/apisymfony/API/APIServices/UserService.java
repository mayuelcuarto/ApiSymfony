package com.cristhian.apisymfony.API.APIServices;

import com.cristhian.apisymfony.Models.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by Cristhian on 20-12-2017.
 */

public interface UserService {
    /*@GET("weather")
    Call<City> getCity(@Query("q") String city, @Query("appid") String key);*/

    //@GET("user")
    //Call<User> userById(@Query("id") String id);

    //@GET("user/{id}")
    //Call<User> userById(@Path("id") int id);

    @POST("login")
    @FormUrlEncoded
    Call<User> userLogin(@Field("json") User usuario);

    @POST("usuario/{id}")
    @FormUrlEncoded
    Call<User> pruebas(@Field("authorization") String token, @Path("id") int id);
}
