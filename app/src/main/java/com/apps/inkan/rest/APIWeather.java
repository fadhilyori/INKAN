package com.apps.inkan.rest;

import com.apps.inkan.Model.WeatherModel;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Header;

/**
 * Created by user on 10/01/2018.
 */

public class APIWeather {
    public static String BASE_URL = "http://dataservice.accuweather.com";
    public static APIService.PostService service_post = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build().create(APIService.PostService.class);

    public static APIService.GetService service_get = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build().create(APIService.GetService.class);

//    public interface GetService{
//        @GET("currentconditions/v1/62")
//        Call<WeatherModel> getWeather (@query("apikey=0eGtqDFLAOGC0XSA8ZGFVipGmVLeae") String password_hash);
}
