package com.example.jonguk.nyttest.screen.story_list.list;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jonguk.nyttest.json.StoryJson;
import com.example.jonguk.nyttest.screen.story_list.list.viewholder.AbsStoryListViewHolder;
import com.example.jonguk.nyttest.screen.story_list.list.viewholder.StoryLandViewHolder;
import com.example.jonguk.nyttest.screen.story_list.list.viewholder.StoryPortViewHolder;
import com.example.jonguk.nyttest.screen.story_list.list.viewholder.StoryTextViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jonguk on 2016. 12. 31..
 */

public class StoryListAdapter extends RecyclerView.Adapter<AbsStoryListViewHolder> {

    private final List<StoryJson> mItems = new ArrayList<>();
    private final AbsStoryListViewHolder.OnItemClickListener mItemClickListener;

    public StoryListAdapter(AbsStoryListViewHolder.OnItemClickListener itemClickListener) {
        mItemClickListener = itemClickListener;
        setHasStableIds(true);
    }

    public void initItems(List<StoryJson> list) {
        mItems.clear();
        mItems.addAll(list);
        notifyDataSetChanged();
    }

    public StoryJson getItem(int position) {
        return mItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return mItems.get(position).getId();
    }

    @Override
    public int getItemViewType(int position) {
        return mItems.get(position).getTypeOrdinal();
    }

    @Override
    public AbsStoryListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        StoryJson.Type type = StoryJson.Type.values()[viewType];
        View view = LayoutInflater.from(parent.getContext()).inflate(type.layoutId, parent, false);
        switch (type) {
            case TEXT:
                return new StoryTextViewHolder(view, mItemClickListener);
            case LANDSCAPE:
                return new StoryLandViewHolder(view, mItemClickListener);
            case PORTRAIT:
                return new StoryPortViewHolder(view, mItemClickListener);
            default:
                return null;
        }
    }

    @Override
    public void onBindViewHolder(AbsStoryListViewHolder holder, int position) {
        holder.bind(mItems.get(position));
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

}
