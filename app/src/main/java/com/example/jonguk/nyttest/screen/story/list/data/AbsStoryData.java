package com.example.jonguk.nyttest.screen.story.list.data;

import android.support.annotation.LayoutRes;

import com.example.jonguk.nyttest.R;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Jonguk on 2016. 12. 31..
 */

public class AbsStoryData {
    public enum Type {
        TITLE(R.layout.item_story_title),
        IMAGE(R.layout.item_story_image),
        ABSTRACT(R.layout.item_story_abstract);

        public int layoutId;
        Type(@LayoutRes int layoutId) {
            this.layoutId = layoutId;
        }
    }

    private static final AtomicLong sIdGenerator = new AtomicLong();
    private long id;

    private Type type;
    AbsStoryData(Type type) {
        this.type = type;
        id = sIdGenerator.getAndIncrement();
    }

    public long getId() {
        return id;
    }

    public int getTypeOrdinal() {
        return type.ordinal();
    }
}
