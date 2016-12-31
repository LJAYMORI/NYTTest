package com.example.jonguk.nyttest.screen.story_list;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.example.jonguk.nyttest.R;
import com.example.jonguk.nyttest.utils.activity.BaseActivity;

import butterknife.BindView;

public class StoryListActivity extends BaseActivity {

    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;

    private StaggeredGridLayoutManager mLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_list);
    }
}
