package com.example.jonguk.nyttest.utils.parser;

import android.support.annotation.NonNull;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by Jonguk on 2016. 12. 31..
 */

public class GsonFactory {
    private static Gson sGson;
    @NonNull
    public static Gson getGson() {
        if (sGson == null) {
            synchronized (GsonFactory.class) {
                if (sGson == null) {
//                    sGson = new Gson();
                    sGson = new GsonBuilder().setPrettyPrinting().create();
                }
            }
        }
        return sGson;
    }
}
