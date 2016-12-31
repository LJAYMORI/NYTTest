package com.example.jonguk.nyttest.screen.story.list.viewholder;

import android.view.View;
import android.widget.TextView;

import com.example.jonguk.nyttest.R;
import com.example.jonguk.nyttest.screen.story.list.data.StoryByData;

import butterknife.BindView;

/**
 * Created by Jonguk on 2016. 12. 31..
 */

public class StoryByViewHolder extends AbsStoryViewHolder<StoryByData> {

    @BindView(R.id.story_by_line)
    TextView mByLineView;

    public StoryByViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void bind(StoryByData data) {
        mByLineView.setText(data.byline);
    }
}
