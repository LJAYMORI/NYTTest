package com.example.jonguk.nyttest.screen.story.list;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jonguk.nyttest.json.StoryJson;
import com.example.jonguk.nyttest.screen.story.list.data.AbsStoryData;
import com.example.jonguk.nyttest.screen.story.list.data.StoryAbstractData;
import com.example.jonguk.nyttest.screen.story.list.data.StoryByData;
import com.example.jonguk.nyttest.screen.story.list.data.StoryImageData;
import com.example.jonguk.nyttest.screen.story.list.data.StoryTimesData;
import com.example.jonguk.nyttest.screen.story.list.data.StoryTitleData;
import com.example.jonguk.nyttest.screen.story.list.viewholder.AbsStoryViewHolder;
import com.example.jonguk.nyttest.screen.story.list.viewholder.StoryAbstractViewHolder;
import com.example.jonguk.nyttest.screen.story.list.viewholder.StoryByViewHolder;
import com.example.jonguk.nyttest.screen.story.list.viewholder.StoryImageViewHolder;
import com.example.jonguk.nyttest.screen.story.list.viewholder.StoryTimesViewHolder;
import com.example.jonguk.nyttest.screen.story.list.viewholder.StoryTitleViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jonguk on 2016. 12. 31..
 */

public class StoryAdapter extends RecyclerView.Adapter<AbsStoryViewHolder> {

    private final List<AbsStoryData> mItems = new ArrayList<>();

    public void initItems(StoryJson storyJson) {
        mItems.clear();
        mItems.add(new StoryTitleData(storyJson.title));
        mItems.add(new StoryTimesData(storyJson.updatedDate, storyJson.publishedDate));
        String imageUrl = storyJson.getJumboImageUrl();
        String thumbnailUrl = storyJson.getThumbnailUrl();
        if (!TextUtils.isEmpty(imageUrl)) {
            mItems.add(new StoryImageData(imageUrl, thumbnailUrl));
        }
        mItems.add(new StoryAbstractData(storyJson.abs));
        mItems.add(new StoryByData(storyJson.byline));
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        return mItems.get(position).getTypeOrdinal();
    }

    @Override
    public AbsStoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        AbsStoryData.Type type = AbsStoryData.Type.values()[viewType];
        View view = LayoutInflater.from(parent.getContext()).inflate(type.layoutId, parent, false);
        switch (type) {
            case TITLE:
                return new StoryTitleViewHolder(view);
            case TIMES:
                return new StoryTimesViewHolder(view);
            case IMAGE:
                return new StoryImageViewHolder(view);
            case ABSTRACT:
                return new StoryAbstractViewHolder(view);
            case BYLINE:
                return new StoryByViewHolder(view);
            default:
                return null;
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public void onBindViewHolder(AbsStoryViewHolder holder, int position) {
        holder.bind(mItems.get(position));
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }
}
