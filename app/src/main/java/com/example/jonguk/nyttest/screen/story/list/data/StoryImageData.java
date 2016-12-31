package com.example.jonguk.nyttest.screen.story.list.data;

/**
 * Created by Jonguk on 2016. 12. 31..
 */

public class StoryImageData extends AbsStoryData {

    public String imageUrl;
    public String thumbnailUrl;

    public StoryImageData(String imageUrl, String thumbnailUrl) {
        super(Type.IMAGE);
        this.imageUrl = imageUrl;
        this.thumbnailUrl = thumbnailUrl;
    }

}
