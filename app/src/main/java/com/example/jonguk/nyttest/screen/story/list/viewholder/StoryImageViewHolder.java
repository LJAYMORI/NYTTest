package com.example.jonguk.nyttest.screen.story.list.viewholder;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;

import com.example.jonguk.nyttest.R;
import com.example.jonguk.nyttest.screen.story.list.data.StoryImageData;
import com.example.jonguk.nyttest.utils.image_loader.ImageLoader;

import butterknife.BindView;

/**
 * Created by Jonguk on 2016. 12. 31..
 */

public class StoryImageViewHolder extends AbsStoryViewHolder<StoryImageData> {

    @BindView(R.id.story_image)
    ImageView mImageView;

    public StoryImageViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void bind(StoryImageData data) {
        String imageUrl = data.imageUrl;
        if (!TextUtils.isEmpty(imageUrl)) {
            ImageLoader.getInstance().with(itemView.getContext())
                    .load(imageUrl)
                    .into(mImageView);
        }
    }
}
