package com.example.juandaniel.practicas.conRx_Retrofit_RecyView;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.juandaniel.practicas.R;
import com.example.juandaniel.practicas.conRx_Retrofit_RecyView.adapters.CategoryAdapter;
import com.example.juandaniel.practicas.conRx_Retrofit_RecyView.domain.Category;
import com.example.juandaniel.practicas.conRx_Retrofit_RecyView.io.ApiAdapter;
import com.example.juandaniel.practicas.conRx_Retrofit_RecyView.io.ApiService;

import java.util.ArrayList;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class RRR_main extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CategoryAdapter categoryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rrr_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        categoryAdapter = new CategoryAdapter(RRR_main.this);

        ApiService apiService = ApiAdapter.getApi();

        loadCategories(apiService);

        setUpList();


    }

    public void loadCategories(ApiService apiService) {


        apiService.getCategories().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<ArrayList<Category>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(ArrayList<Category> value) {
                Log.d("STATUS", "OK");
                Log.d("STATUS", value.toString());
                categoryAdapter.addAll(value);
            }

            @Override
            public void onError(Throwable e) {
                Log.e("STATUS", "ERROR");
                Log.e("STATUS", e.getMessage());

            }

            @Override
            public void onComplete() {

            }
        });


    }

    public void setUpList() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(categoryAdapter);

    }
}
