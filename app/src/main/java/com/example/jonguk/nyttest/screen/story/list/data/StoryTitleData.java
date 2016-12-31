package com.example.jonguk.nyttest.screen.story.list.data;

/**
 * Created by Jonguk on 2016. 12. 31..
 */

public class StoryTitleData extends AbsStoryData {

    public String title;

    public StoryTitleData(String title) {
        super(Type.TITLE);
        this.title = title;
    }

}
