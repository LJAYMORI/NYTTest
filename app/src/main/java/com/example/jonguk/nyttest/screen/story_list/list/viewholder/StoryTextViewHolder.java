package com.example.jonguk.nyttest.screen.story_list.list.viewholder;

import android.view.View;
import android.widget.TextView;

import com.example.jonguk.nyttest.R;
import com.example.jonguk.nyttest.json.StoryJson;

import butterknife.BindView;

/**
 * Created by Jonguk on 2016. 12. 31..
 */

public class StoryTextViewHolder extends AbsStoryListViewHolder {

    @BindView(R.id.story_text_title)
    TextView mTitleView;
    @BindView(R.id.story_text_abstract)
    TextView mAbstractView;

    public StoryTextViewHolder(View itemView, OnItemClickListener itemClickListener) {
        super(itemView);
        setOnItemClickListener(itemClickListener);
    }

    @Override
    public void bind(StoryJson storyJson) {
        mTitleView.setText(storyJson.title);
        mAbstractView.setText(storyJson.abs);
        itemView.setOnClickListener(v -> {
            if (mItemClickListener != null) {
                mItemClickListener.onItemClick(getAdapterPosition());
            }
        });
    }
}
