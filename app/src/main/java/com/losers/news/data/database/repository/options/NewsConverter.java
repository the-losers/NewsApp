package com.losers.news.data.database.repository.options;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.losers.news.data.network.Article;

import java.lang.reflect.Type;
import java.util.List;

import androidx.room.TypeConverter;

public class NewsConverter {

    @TypeConverter
    public static List<Article> fromString(String value) {
        Type listType = new TypeToken<List<Article>>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public static String fromArrayList(List<Article> list) {
        Gson gson = new Gson();
        String json = gson.toJson(list);
        return json;
    }
}
