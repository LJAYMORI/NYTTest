package com.example.jonguk.nyttest.data;

import java.io.Serializable;

/**
 * Created by Jonguk on 2016. 12. 31..
 */

public class MultimediumJson implements Serializable {

    public static final String IMAGE_TYPE_STANDARD_THUMBNAIL = "Standard Thumbnail";
    public static final String IMAGE_TYPE_THUMBNAIL_LARGE = "thumbLarge";
    public static final String IMAGE_TYPE_NORMAL = "Normal";
    public static final String IMAGE_TYPE_THREE_BY_TWO = "mediumThreeByTwo210";
    public static final String IMAGE_TYPE_SUPER_JUMBO = "superJumbo";


    public String url;
    public String format;
    public float height;
    public float width;
    public String type;
    public String subtype;
    public String caption;
    public String copyright;

    public float getRatio() {
        return height / width;
    }
}
