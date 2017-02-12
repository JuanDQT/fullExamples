package com.example.juandaniel.practicas.conRx_Retrofit_RecyView.io;

import com.example.juandaniel.practicas.conRx_Retrofit_RecyView.domain.Category;

import java.util.ArrayList;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by juandaniel on 12/2/17.
 */

public interface ApiService {

    @GET("/php/getCategories.php")
    Observable<ArrayList<Category>> getCategories();

}
