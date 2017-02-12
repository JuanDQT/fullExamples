package com.example.juandaniel.practicas.conRetrofit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.juandaniel.practicas.R;
import com.example.juandaniel.practicas.conRetrofit.domain.Contacto;
import com.example.juandaniel.practicas.conRetrofit.io.ApiAdapter;
import com.example.juandaniel.practicas.conRetrofit.io.ApiService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class conRetrofitActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_con_retrofit);

        ApiService apiService = ApiAdapter.getApi();

        Call<ArrayList<Contacto>> list = apiService.getContactos();

        list.enqueue(new Callback<ArrayList<Contacto>>() {
            @Override
            public void onResponse(Call<ArrayList<Contacto>> call, Response<ArrayList<Contacto>> response) {

                ArrayList<Contacto> contactos = response.body();

                for (Contacto contacto : contactos) {
                    Log.d("NOMBRE", contacto.getName());
                    Log.d("TELEFONO", contacto.getPhone());
                }

            }

            @Override
            public void onFailure(Call<ArrayList<Contacto>> call, Throwable t) {
                Log.e("STATUS", "404");

            }
        });
    }
}
