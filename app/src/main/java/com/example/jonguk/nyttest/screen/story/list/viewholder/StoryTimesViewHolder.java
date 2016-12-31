package com.example.jonguk.nyttest.screen.story.list.viewholder;

import android.view.View;
import android.widget.TextView;

import com.example.jonguk.nyttest.R;
import com.example.jonguk.nyttest.screen.story.list.data.StoryTimesData;

import butterknife.BindView;

/**
 * Created by Jonguk on 2016. 12. 31..
 */

public class StoryTimesViewHolder extends AbsStoryViewHolder<StoryTimesData> {

    @BindView(R.id.story_updated_time)
    TextView mUpdatedAtView;
    @BindView(R.id.story_published_time)
    TextView mPublishedAtView;

    public StoryTimesViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void bind(StoryTimesData data) {
        mUpdatedAtView.setText(String.format("UpdatedAt: %s", data.updatedAt));
        mPublishedAtView.setText(String.format("PublishedAt: %s", data.publishedAt));
    }
}
