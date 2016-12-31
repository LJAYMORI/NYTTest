package com.example.jonguk.nyttest.screen.story.list.data;

/**
 * Created by Jonguk on 2016. 12. 31..
 */

public class StoryAbstractData extends AbsStoryData {

    public String abs;

    public StoryAbstractData(String abs) {
        super(Type.ABSTRACT);
        this.abs = abs;
    }

}
