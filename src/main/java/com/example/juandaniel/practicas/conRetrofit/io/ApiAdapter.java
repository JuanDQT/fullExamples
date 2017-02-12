package com.example.juandaniel.practicas.conRetrofit.io;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by juandaniel on 10/2/17.
 */

public class ApiAdapter {

    private static ApiService apiService;

    public static ApiService getApi() {

        if (apiService == null) {

            Retrofit retrofit = new Retrofit.Builder().
                                baseUrl(Constants.BASE_URL).
                                addConverterFactory(GsonConverterFactory.create()).
                                build();

            apiService = retrofit.create(ApiService.class);
        }


        return apiService;
    }
}
