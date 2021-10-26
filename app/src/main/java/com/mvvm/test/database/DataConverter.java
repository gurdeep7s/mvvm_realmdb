package com.mvvm.test.database;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mvvm.test.ui.fragment.productlist.model.ColorOption;
import com.mvvm.test.ui.fragment.productlist.model.Product;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.List;

public class DataConverter implements Serializable {
 
 @TypeConverter
    public String convertToString(List<ColorOption> optionValues) {
        if (optionValues == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<Product>>() {
        }.getType();
        String json = gson.toJson(optionValues, type);
        return json;
    }
 
    @TypeConverter
    public List<ColorOption> fromStringToList(String optionValuesString) {
        if (optionValuesString == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<Product>>() {
        }.getType();
        List<ColorOption> productCategoriesList = gson.fromJson(optionValuesString, type);
        return productCategoriesList;
    }
 
}