package com.example.post_request;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiService {

    @POST("posts")
    Call<ResponseModel> sendPost(@Body RequestModel requestModel);
}