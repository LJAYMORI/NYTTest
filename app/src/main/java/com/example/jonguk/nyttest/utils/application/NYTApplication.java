package com.example.jonguk.nyttest.utils.application;

import android.app.Application;

import com.bumptech.glide.Glide;

/**
 * Created by Jonguk on 2016. 12. 31..
 */

public class NYTApplication extends Application {

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        Glide.get(this).trimMemory(level);
    }

}
