package com.apps.inkan.rest;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by user on 21/12/2017.
 */

public class APIService {
    @FormUrlEncoded
    @POST("jk.php")
    Call<ResponseBody> loginRequest(@Field("username") String use)
}
