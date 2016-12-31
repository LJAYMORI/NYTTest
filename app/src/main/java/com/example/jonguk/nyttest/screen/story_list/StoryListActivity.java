package com.example.jonguk.nyttest.screen.story_list;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.example.jonguk.nyttest.R;
import com.example.jonguk.nyttest.screen.story_list.listview.StoryListAdapter;
import com.example.jonguk.nyttest.utils.activity.BaseActivity;

import butterknife.BindView;

public class StoryListActivity extends BaseActivity {

    private static final String TAG = "StoryListActivity";

    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;

    private StoryListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_list);

        mRecyclerView.setLayoutManager(
                new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        mAdapter = new StoryListAdapter();
        mRecyclerView.setAdapter(mAdapter);

        requestStories();
    }

    private void requestStories() {
        StoryListRequest.getStoryList()
                .takeUntil(destroySignal())
                .subscribe(storyListJson -> {
                    mAdapter.setItems(storyListJson.results);
                }, err -> {

                });
    }
}
