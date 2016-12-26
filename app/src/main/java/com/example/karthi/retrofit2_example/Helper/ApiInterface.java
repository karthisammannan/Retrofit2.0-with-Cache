package com.example.karthi.retrofit2_example.Helper;


import com.example.karthi.retrofit2_example.Response.BasicResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {


    @GET("volleyExample/film.php")
    Call<BasicResponse> getData();

}
