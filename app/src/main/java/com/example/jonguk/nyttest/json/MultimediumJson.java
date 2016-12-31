package com.example.jonguk.nyttest.json;

import java.io.Serializable;

/**
 * Created by Jonguk on 2016. 12. 31..
 */

public class MultimediumJson implements Serializable {
    public enum ImageType {
        STANDARD_THUMBNAIL("Standard Thumbnail"),
        THUMBNAIL_LARGE("thumbLarge"),
        NORMAL("Normal"),
        THREE_BY_TWO("mediumThreeByTwo210"),
        SUPER_JUMBO("superJumbo");

        public String format;
        ImageType(String format) {
            this.format = format;
        }

        public boolean equals(String format) {
            return this.format.equalsIgnoreCase(format);
        }
    }

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
