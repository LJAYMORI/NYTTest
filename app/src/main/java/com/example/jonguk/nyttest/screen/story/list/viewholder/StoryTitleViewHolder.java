package com.example.jonguk.nyttest.screen.story.list.viewholder;

import android.view.View;
import android.widget.TextView;

import com.example.jonguk.nyttest.R;
import com.example.jonguk.nyttest.screen.story.list.data.StoryTitleData;

import butterknife.BindView;

/**
 * Created by Jonguk on 2016. 12. 31..
 */

public class StoryTitleViewHolder extends AbsStoryViewHolder<StoryTitleData> {

    @BindView(R.id.story_title)
    TextView mTitleView;

    public StoryTitleViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void bind(StoryTitleData data) {
        mTitleView.setText(data.title);
    }
}
