package com.example.jonguk.nyttest.data;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;

import com.example.jonguk.nyttest.R;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jonguk on 2016. 12. 31..
 */

public class StoryJson {
    public enum Type {
        TEXT(R.layout.item_story_list_text),
        LANDSCAPE(R.layout.item_story_list_land),
        PORTRAIT(R.layout.item_story_list_port);

        public int layoutId;
        Type(@LayoutRes int layoutId) {
            this.layoutId = layoutId;
        }
    }

    private long id;
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
        return url.hashCode();
    }

    public int getTypeOrdinal() {
        MultimediumJson multimediumJson = getNormalMediumJson();
        if (multimediaList.size() == 0 || multimediumJson == null) {
            return Type.TEXT.ordinal();
        } else {
            return multimediumJson.getRatio() < 1.2f ?
                    Type.LANDSCAPE.ordinal() : Type.PORTRAIT.ordinal();
        }
    }

    @Nullable
    public String getThumbnailUrl() {
        MultimediumJson thumbnail = getNormalMediumJson();
        return thumbnail != null ? thumbnail.url :
                "http://www.thewoodjoynt.com/Content/Images/Products/NoImageAvailable.jpg";
    }

    public MultimediumJson getNormalMediumJson() {
        MultimediumJson thumbnail = null;
        for (MultimediumJson multimediumJson : multimediaList) {
            String format = multimediumJson.format;
            if (MultimediumJson.IMAGE_TYPE_STANDARD_THUMBNAIL.equalsIgnoreCase(format) ||
                    MultimediumJson.IMAGE_TYPE_THUMBNAIL_LARGE.equalsIgnoreCase(format) ||
                    MultimediumJson.IMAGE_TYPE_THREE_BY_TWO.equalsIgnoreCase(format)) {
                thumbnail = multimediumJson;
            } else if (MultimediumJson.IMAGE_TYPE_NORMAL.equalsIgnoreCase(format)) {
                return multimediumJson;
            }
        }
        return thumbnail;
    }
}
