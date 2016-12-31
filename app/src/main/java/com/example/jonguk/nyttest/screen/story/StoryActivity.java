package com.example.jonguk.nyttest.screen.story;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.jonguk.nyttest.R;
import com.example.jonguk.nyttest.json.StoryJson;
import com.example.jonguk.nyttest.screen.story.list.StoryAdapter;
import com.example.jonguk.nyttest.utils.activity.BaseActivity;

import butterknife.BindView;

/**
 * Created by Jonguk on 2016. 12. 31..
 */

public class StoryActivity extends BaseActivity {

    public static final String ARG_STORY_JSON = "story_json";
    private StoryJson mStoryJson;

    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;
    StoryAdapter mAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        if (initArgs()) {
            initActionBar();

            mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
            mAdapter = new StoryAdapter();
            mRecyclerView.setAdapter(mAdapter);

            mAdapter.initItems(mStoryJson);
        }
    }

    private void initActionBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            toolbar.setTitle("");
            toolbar.setNavigationIcon(R.drawable.ic_close_grey);
            toolbar.setNavigationOnClickListener(v -> finish());
        }
    }

    private boolean initArgs() {
        mStoryJson = (StoryJson) getIntent().getSerializableExtra(ARG_STORY_JSON);
        if (mStoryJson == null) {
            showToast("invalid argument");
            finish();
            return false;
        }
        return true;
    }

    public static Intent createArguments(Context context, StoryJson storyJson) {
        Intent intent = new Intent(context, StoryActivity.class);
        intent.putExtra(ARG_STORY_JSON, storyJson);
        return intent;
    }
}
