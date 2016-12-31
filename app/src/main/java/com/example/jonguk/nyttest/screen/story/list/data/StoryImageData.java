package com.example.jonguk.nyttest.screen.story.list.data;

/**
 * Created by Jonguk on 2016. 12. 31..
 */

public class StoryImageData extends AbsStoryData {

    public String imageUrl;

    public StoryImageData(String imageUrl) {
        super(Type.IMAGE);
        this.imageUrl = imageUrl;
    }

}
