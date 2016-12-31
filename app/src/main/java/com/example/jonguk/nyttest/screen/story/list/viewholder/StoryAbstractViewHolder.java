package com.example.jonguk.nyttest.screen.story.list.viewholder;

import android.text.Html;
import android.view.View;
import android.widget.TextView;

import com.example.jonguk.nyttest.R;
import com.example.jonguk.nyttest.screen.story.list.data.StoryAbstractData;

import butterknife.BindView;

/**
 * Created by Jonguk on 2016. 12. 31..
 */

public class StoryAbstractViewHolder extends AbsStoryViewHolder<StoryAbstractData> {

    @BindView(R.id.story_abstract)
    TextView mAbsView;

    public StoryAbstractViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void bind(StoryAbstractData data) {
        mAbsView.setText(Html.fromHtml(data.abs));
    }
}
