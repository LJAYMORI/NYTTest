package com.example.jonguk.nyttest.data;

/**
 * Created by Jonguk on 2016. 12. 31..
 */

public class MultimediumJson {
    public String url;
    public String format;
    public int height;
    public int width;
    public String type;
    public String subtype;
    public String caption;
    public String copyright;

    public float getRatio() {
        return (float) width / height;
    }
}
