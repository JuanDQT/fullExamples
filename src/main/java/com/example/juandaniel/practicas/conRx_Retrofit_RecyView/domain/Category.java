package com.example.juandaniel.practicas.conRx_Retrofit_RecyView.domain;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by juandaniel on 12/2/17.
 */

public class Category {
    @SerializedName("id_category")
    @Expose
    private String idCategory;
    @SerializedName("name_category")
    @Expose
    private String nameCategory;
    @SerializedName("sub_array")
    @Expose
    private List<SubArray> subArray = null;

    public String getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(String idCategory) {
        this.idCategory = idCategory;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public List<SubArray> getSubArray() {
        return subArray;
    }

    public void setSubArray(List<SubArray> subArray) {
        this.subArray = subArray;
    }

    @Override
    public String toString() {
        return "Category{" +
                "idCategory='" + idCategory + '\'' +
                ", nameCategory='" + nameCategory + '\'' +
                ", subArray=" + subArray +
                '}';
    }

    public class SubArray {

        @SerializedName("id_sub_category")
        @Expose
        private String idSubCategory;
        @SerializedName("name_sub_category")
        @Expose
        private String nameSubCategory;

        public String getIdSubCategory() {
            return idSubCategory;
        }

        public void setIdSubCategory(String idSubCategory) {
            this.idSubCategory = idSubCategory;
        }

        public String getNameSubCategory() {
            return nameSubCategory;
        }

        public void setNameSubCategory(String nameSubCategory) {
            this.nameSubCategory = nameSubCategory;
        }



    }
}
