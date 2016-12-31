package com.example.jonguk.nyttest.screen.story.list.data;

/**
 * Created by Jonguk on 2016. 12. 31..
 */

public class StoryByData extends AbsStoryData {

    public String byline;

    public StoryByData(String byline) {
        super(Type.BYLINE);
        this.byline = byline;
    }
}
