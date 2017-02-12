package com.example.juandaniel.practicas.conRetrofit.io;

import com.example.juandaniel.practicas.conRetrofit.domain.Contacto;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by juandaniel on 10/2/17.
 */

public interface ApiService {

    @GET("webservice/respuesta.php")
    Call<ArrayList<Contacto>> getContactos();

}
