package com.oktydeniz.exampleapp.network;

import com.oktydeniz.exampleapp.models.ColorsPojo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RestApi {

    @GET("colorapi")
    Call<List<ColorsPojo>> getAllColors();
}
