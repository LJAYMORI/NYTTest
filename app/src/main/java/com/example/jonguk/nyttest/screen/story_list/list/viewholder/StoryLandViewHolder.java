package com.example.jonguk.nyttest.screen.story_list.list.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jonguk.nyttest.R;
import com.example.jonguk.nyttest.json.StoryJson;
import com.example.jonguk.nyttest.utils.image_loader.ImageLoader;

import butterknife.BindView;

/**
 * Created by Jonguk on 2016. 12. 31..
 */

public class StoryLandViewHolder extends AbsStoryListViewHolder {

    @BindView(R.id.story_land_image)
    ImageView mImageView;
    @BindView(R.id.story_land_title)
    TextView mTitleView;

    public StoryLandViewHolder(View itemView, OnItemClickListener itemClickListener) {
        super(itemView);
        setOnItemClickListener(itemClickListener);
    }

    @Override
    public void bind(StoryJson storyJson) {
//        ViewGroup.LayoutParams lp = mImageView.getLayoutParams();
//        lp.width = ViewGroup.LayoutParams.MATCH_PARENT;
//        lp.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        ImageLoader.getInstance().with(itemView.getContext())
                .load(storyJson.getThumbnailUrl())
                .into(mImageView);
        mTitleView.setText(storyJson.title);
        itemView.setOnClickListener(v -> {
            if (mItemClickListener != null) {
                mItemClickListener.onItemClick(getAdapterPosition());
            }
        });
    }
}
