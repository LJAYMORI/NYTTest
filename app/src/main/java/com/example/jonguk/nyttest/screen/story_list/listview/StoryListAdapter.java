package com.example.jonguk.nyttest.screen.story_list.listview;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.example.jonguk.nyttest.data.StoryJson;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jonguk on 2016. 12. 31..
 */

public class StoryListAdapter extends RecyclerView.Adapter<AbsStoryViewHolder> {

    private final List<StoryJson> mItems = new ArrayList<>();

    public void setItems(List<StoryJson> list) {
        mItems.clear();
        mItems.addAll(list);
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        return mItems.get(position).getTypeOrdinal();
    }

    @Override
    public AbsStoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        StoryJson.Type type = StoryJson.Type.values()[viewType];
        switch (type) {
            case TEXT:
                return null;
            case LANDSCAPE:
                return null;
            case PORTRAIT:
                return null;
            case INVALID:
            default:
                return null;
        }
    }

    @Override
    public void onBindViewHolder(AbsStoryViewHolder holder, int position) {
        holder.bind(mItems.get(position));
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }
}
