package com.example.jonguk.nyttest.screen.story_list.list.viewholder;

import android.graphics.Bitmap;
import android.support.v7.graphics.Palette;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.example.jonguk.nyttest.R;
import com.example.jonguk.nyttest.json.MultimediumJson;
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
        MultimediumJson mediumJson = storyJson.getMediumJsonFromType(MultimediumJson.ImageType.NORMAL);
        int measuredWidth = mImageView.getMeasuredWidth();
        if (measuredWidth > 0 && mediumJson != null) {
            ViewGroup.LayoutParams lp = mImageView.getLayoutParams();
            lp.height = (int) (mediumJson.height * measuredWidth / mediumJson.width);
            itemView.requestLayout();
        }
        ImageLoader.getInstance().with(itemView.getContext())
                .load(storyJson.getThumbnailUrl())
                .asBitmap()
                .dontAnimate()
                .listener(new RequestListener<String, Bitmap>() {
                    @Override
                    public boolean onException(Exception e, String model, Target<Bitmap> target, boolean isFirstResource) {
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Bitmap resource, String model, Target<Bitmap> target, boolean isFromMemoryCache, boolean isFirstResource) {
                        Palette.from(resource).generate(palette -> {
                            Palette.Swatch swatch = palette.getDarkVibrantSwatch();
                            if (swatch != null) {
                                mTitleView.setBackgroundColor(swatch.getRgb());
                                mTitleView.setTextColor(swatch.getBodyTextColor());
                            }
                        });
                        return false;
                    }
                })
                .into(mImageView);

        mTitleView.setText(storyJson.title);
        itemView.setOnClickListener(v -> {
            if (mItemClickListener != null) {
                mItemClickListener.onItemClick(getAdapterPosition());
            }
        });
    }
}
