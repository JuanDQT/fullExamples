package com.example.juandaniel.practicas.conRx_Retrofit_RecyView.adapters;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.juandaniel.practicas.R;
import com.example.juandaniel.practicas.conRx_Retrofit_RecyView.domain.Category;

import java.util.ArrayList;

/**
 * Created by juandaniel on 12/2/17.
 */

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryAdapterViewHolder>{

    private Activity activity;
    private int label = R.layout.category_label;
    private ArrayList<Category> categories;

    public CategoryAdapter(Activity activity) {
        this.activity = activity;
        this.categories = new ArrayList<>();
    }

    @Override
    public CategoryAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(label, parent, false);
        return new CategoryAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CategoryAdapterViewHolder holder, int position) {
        holder.tvName.setText(categories.get(position).getNameCategory());
        //holder.tvDescription.setText(categories.get(position).getSubArray().get(0).getNameSubCategory());
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    class CategoryAdapterViewHolder extends RecyclerView.ViewHolder {

        private TextView tvName;
        private TextView tvDescription;

        public CategoryAdapterViewHolder(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tvName);
            tvDescription = (TextView) itemView.findViewById(R.id.tvDescription);

        }
    }

    public void addAll(ArrayList<Category> categories) {

        this.categories.addAll(categories);
        this.notifyDataSetChanged();
    }

}
