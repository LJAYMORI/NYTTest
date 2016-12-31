package com.example.jonguk.nyttest.json;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;

import com.example.jonguk.nyttest.R;
import com.example.jonguk.nyttest.utils.image_loader.ImageLoader;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Jonguk on 2016. 12. 31..
 */

public class StoryJson implements Parcelable {
    public enum Type {
        TEXT(R.layout.item_story_list_text),
        LANDSCAPE(R.layout.item_story_list_land),
        PORTRAIT(R.layout.item_story_list_port);

        public int layoutId;
        Type(@LayoutRes int layoutId) {
            this.layoutId = layoutId;
        }
    }

    private static final AtomicLong sIdGenerator = new AtomicLong();
    public long id = sIdGenerator.getAndIncrement();

    public String section;
    public String subsection;
    public String title;
    @SerializedName("abstract")
    public String abs;
    public String url;
    public String byline;
    @SerializedName("item_type")
    public String itemType;
    @SerializedName("updated_date")
    public String updatedDate;
    @SerializedName("created_date")
    public String createdDate;
    @SerializedName("published_date")
    public String publishedDate;
    @SerializedName("material_type_facet")
    public String materialTypeFacet;
    public String kicker;
    @SerializedName("des_facet")
    public List<String> desFacet = null;
    @SerializedName("org_facet")
    public List<String> orgFacet = null;
    @SerializedName("per_facet")
    public List<String> perFacet = null;
    @SerializedName("geo_facet")
    public List<String> geoFacet = null;
    @SerializedName("multimedia")
    public List<MultimediumJson> multimediaList = new ArrayList<>();
    @SerializedName("short_url")
    public String shortUrl;

    public long getId() {
        return id;
    }

    public int getTypeOrdinal() {
        MultimediumJson multimediumJson = getMediumJsonFromType(MultimediumJson.ImageType.NORMAL);
        if (multimediaList.size() == 0 || multimediumJson == null) {
            return Type.TEXT.ordinal();
        } else {
            return multimediumJson.getRatio() < 1.2f ?
                    Type.LANDSCAPE.ordinal() : Type.PORTRAIT.ordinal();
        }
    }

    public String getThumbnailUrl() {
        MultimediumJson thumbnail = getMediumJsonFromType(MultimediumJson.ImageType.NORMAL);
        return thumbnail != null ? thumbnail.url : ImageLoader.NO_IMAGE;
    }

    public String getJumboImageUrl() {
        MultimediumJson thumbnail = getMediumJsonFromType(MultimediumJson.ImageType.SUPER_JUMBO);
        return thumbnail != null ? thumbnail.url : "";
    }

    @Nullable
    public MultimediumJson getMediumJsonFromType(MultimediumJson.ImageType type) {
        MultimediumJson thumbnail = null;
        for (MultimediumJson multimediumJson : multimediaList) {
            String format = multimediumJson.format;
            if (type.equals(format)) {
                return multimediumJson;
            } else {
                thumbnail = multimediumJson;
            }
        }
        return thumbnail;
    }

    protected StoryJson(Parcel in) {
        id = in.readLong();
        section = in.readString();
        subsection = in.readString();
        title = in.readString();
        abs = in.readString();
        url = in.readString();
        byline = in.readString();
        itemType = in.readString();
        updatedDate = in.readString();
        createdDate = in.readString();
        publishedDate = in.readString();
        materialTypeFacet = in.readString();
        kicker = in.readString();
        desFacet = in.createStringArrayList();
        orgFacet = in.createStringArrayList();
        perFacet = in.createStringArrayList();
        geoFacet = in.createStringArrayList();
        shortUrl = in.readString();
    }

    public static final Creator<StoryJson> CREATOR = new Creator<StoryJson>() {
        @Override
        public StoryJson createFromParcel(Parcel in) {
            return new StoryJson(in);
        }

        @Override
        public StoryJson[] newArray(int size) {
            return new StoryJson[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(section);
        dest.writeString(subsection);
        dest.writeString(title);
        dest.writeString(abs);
        dest.writeString(url);
        dest.writeString(byline);
        dest.writeString(itemType);
        dest.writeString(updatedDate);
        dest.writeString(createdDate);
        dest.writeString(publishedDate);
        dest.writeString(materialTypeFacet);
        dest.writeString(kicker);
        dest.writeStringList(desFacet);
        dest.writeStringList(orgFacet);
        dest.writeStringList(perFacet);
        dest.writeStringList(geoFacet);
        dest.writeString(shortUrl);
    }
}
