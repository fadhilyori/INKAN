package com.apps.inkan.rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by user on 21/12/2017.
 */

public class APIClient {
    public String url = fhchcvhcvh;
    static Retrofit retrofit = null;

    public static Retrofit getClient(){
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .addConverterFactory()
                    .baseUrl()
                    .build();
        }
        return retrofit;
    }
}
