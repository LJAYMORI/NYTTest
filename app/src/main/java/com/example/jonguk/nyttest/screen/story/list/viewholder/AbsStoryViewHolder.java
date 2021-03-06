package com.example.jonguk.nyttest.screen.story.list.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.jonguk.nyttest.screen.story.list.data.AbsStoryData;

import butterknife.ButterKnife;

/**
 * Created by Jonguk on 2016. 12. 31..
 */

public abstract class AbsStoryViewHolder<T extends AbsStoryData> extends RecyclerView.ViewHolder {

    public AbsStoryViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public abstract void bind(T data);
}
