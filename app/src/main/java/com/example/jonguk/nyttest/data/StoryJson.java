package com.example.jonguk.nyttest.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Jonguk on 2016. 12. 31..
 */

public class StoryJson {
    public enum Type { INVALID, TEXT, LANDSCAPE,  PORTRAIT }

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
    public List<MultimediumJson> multimediaList = null;
    @SerializedName("short_url")
    public String shortUrl;

    public int getTypeOrdinal() {
        if (multimediaList == null) {
            return Type.INVALID.ordinal();
        } else if (multimediaList.size() == 0) {
            return Type.TEXT.ordinal();
        } else {
            MultimediumJson multimediumJson = multimediaList.get(0);
            return multimediumJson.getRatio() > 0.6 ?
                    Type.LANDSCAPE.ordinal() : Type.PORTRAIT.ordinal();
        }
    }
}
