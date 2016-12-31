package com.example.jonguk.nyttest.screen.story.list.data;

/**
 * Created by Jonguk on 2016. 12. 31..
 */

public class StoryTimesData extends AbsStoryData {

    public String updatedAt;
    public String publishedAt;

    public StoryTimesData(String updatedAt, String publishedAt) {
        super(Type.TIMES);
        this.updatedAt = updatedAt;
        this.publishedAt = publishedAt;
    }


}
