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

    /*protected MultimediumJson(Parcel in) {
        url = in.readString();
        format = in.readString();
        height = in.readFloat();
        width = in.readFloat();
        type = in.readString();
        subtype = in.readString();
        caption = in.readString();
        copyright = in.readString();
    }

    public static final Creator<MultimediumJson> CREATOR = new Creator<MultimediumJson>() {
        @Override
        public MultimediumJson createFromParcel(Parcel in) {
            return new MultimediumJson(in);
        }

        @Override
        public MultimediumJson[] newArray(int size) {
            return new MultimediumJson[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(url);
        dest.writeString(format);
        dest.writeFloat(height);
        dest.writeFloat(width);
        dest.writeString(type);
        dest.writeString(subtype);
        dest.writeString(caption);
        dest.writeString(copyright);
    }*/
}
