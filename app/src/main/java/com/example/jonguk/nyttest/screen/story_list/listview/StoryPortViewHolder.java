package com.example.jonguk.nyttest.screen.story_list.listview;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jonguk.nyttest.R;
import com.example.jonguk.nyttest.data.StoryJson;
import com.example.jonguk.nyttest.utils.image_loader.ImageLoader;

import butterknife.BindView;

/**
 * Created by Jonguk on 2016. 12. 31..
 */

public class StoryPortViewHolder extends AbsStoryViewHolder {

    @BindView(R.id.story_port_image)
    ImageView mBackgroundView;
    @BindView(R.id.story_port_title)
    TextView mTitleView;

    public StoryPortViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void bind(StoryJson storyJson) {
        ImageLoader.getInstance().with(itemView.getContext())
                .load(storyJson.getThumbnailUrl())
                .into(mBackgroundView);
        mTitleView.setText(storyJson.title);
    }
}
