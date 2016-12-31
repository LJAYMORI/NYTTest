package com.example.jonguk.nyttest.utils.image_loader;

import android.content.Context;
import android.support.v4.app.FragmentActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;

public class ImageLoader {

    public static final String NO_IMAGE = "http://www.thewoodjoynt.com/Content/Images/Products/NoImageAvailable.jpg";

    private static ImageLoader sInstance;

    private ImageLoader() {}

    public static ImageLoader getInstance() {
        if (sInstance == null) {
            sInstance = new ImageLoader();
        }
        return sInstance;
    }

    public RequestManager with(Context context) {
        return Glide.with(context);
    }

    public RequestManager with(FragmentActivity context) {
        return Glide.with(context);
    }
}