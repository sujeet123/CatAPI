package com.sujeetkumar.catapp.model.providers.catapi;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CatApiService {

    @GET("/api/images/get?format=xml")
    Call<CatApiElement> getCatApiElementFromEndPoint();

}
