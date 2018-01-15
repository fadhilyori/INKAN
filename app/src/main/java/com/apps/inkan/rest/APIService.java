package com.apps.inkan.rest;
import com.apps.inkan.Model.Artikel;
import com.apps.inkan.Model.ArtikelModel;
import com.apps.inkan.Model.DefaultModel;
import com.apps.inkan.Model.LoginModel;

import com.apps.inkan.LoginActivity;
import com.apps.inkan.Model.LoginModel;
import com.apps.inkan.Model.ProvinsiModel;
import com.apps.inkan.Model.Sale;
import com.apps.inkan.Model.SaleModel;
import com.apps.inkan.Model.User;
import com.apps.inkan.Model.UserModel;

import java.net.InterfaceAddress;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

/**
 * Created by Lenovo on 22/12/2017.
 */

public class APIService {

    public static String BASE_URL = "http://192.168.1.105/INKAN/backend/web/api/";
    public static PostService service_post = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build().create(APIService.PostService.class);

    public static GetService service_get = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build().create(APIService.GetService.class);


    public interface GetService{

        @GET("/api/user/getuser")
        Call<UserModel> getUser(@Header("Authorization") String password_hash);

        @GET("/api/artikel/getartikel")
        Call<Artikel> getArtikel(
                String judul,
                String deskripsi
        );

        @GET("/api/sale/getsale")
        Call<SaleModel> getSale(@Header("Authorization") String id);

        @GET("/api/provinsi/getprovinsi")
        Call<ProvinsiModel> getProvinsi(@Header("Authorization") String id);
    }

    public interface PostService{
        @POST("user/login")
        @FormUrlEncoded
        Call<LoginModel> postLogin(
                @Field("username") String username,
                @Field("password_hash") String password_hash
        );

        @POST("user/register")
        @FormUrlEncoded
        Call<UserModel> postRegister(
                @Field("email") String username,
                @Field("username") String email,
                @Field("password_hash") String password
        );

        @POST("sale/createsale")
        @Multipart
        Call<SaleModel> postSaleMultipart(
                @Part MultipartBody.Part file,
                @Part("gambar") RequestBody name
        );

        @POST("sale/createsale")
        @FormUrlEncoded
        Call<SaleModel> postSale (
//                @Header("Authorization") String auth ,
                @Field("keterangan") String keterangan,
                @Field("harga") int harga,
                @Field("fish_kategori_id") String fish_kategori_id,
                @Field("fish_id") int fish_id
        );

        @POST("user/updateuser")
        @FormUrlEncoded
        Call<UserModel> postUser (
                @Field("username") String username,
                @Field("email") String email,
                @Field("phone_telp") String telp,
                @Field("address") String alamat
        );

        @POST("artikel/createartikel")
        @Multipart
        Call<ArtikelModel> postArtikelMultipart(
                @Part MultipartBody.Part file,
                @Part("picture") RequestBody name
        );
        @POST("artikel/createartikel")
        @FormUrlEncoded
        Call<ArtikelModel> postArtikel(
                @Field("judul") String judul,
                @Field("deskripsi") String deskripsi
                );
    }
}
