package com.example.jonguk.nyttest.screen.story_list.listview;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.jonguk.nyttest.data.StoryJson;

import butterknife.ButterKnife;

/**
 * Created by Jonguk on 2016. 12. 31..
 */

public abstract class AbsStoryViewHolder extends RecyclerView.ViewHolder {

    public AbsStoryViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public abstract void bind(StoryJson storyJson);
}
