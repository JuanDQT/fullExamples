package com.example.juandaniel.practicas.conRx_Retrofit_RecyView.io;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by juandaniel on 12/2/17.
 */

public class ApiAdapter {

    private static ApiService apiService;

    public static ApiService getApi() {

        if (apiService == null) {
            Retrofit retrofit = new Retrofit.Builder().
                    baseUrl(Constants.BASE_URL).
                    addConverterFactory(GsonConverterFactory.create()).
                    addCallAdapterFactory(RxJava2CallAdapterFactory.create()).
                    build();

            apiService = retrofit.create(ApiService.class);
        }

        return apiService;

    }

}
