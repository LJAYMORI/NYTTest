package com.example.jonguk.nyttest.screen.story_list;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.ProgressBar;

import com.example.jonguk.nyttest.R;
import com.example.jonguk.nyttest.json.StoryJson;
import com.example.jonguk.nyttest.screen.story_list.list.StoryListAdapter;
import com.example.jonguk.nyttest.screen.story_list.list.viewholder.AbsStoryListViewHolder;
import com.example.jonguk.nyttest.screen.story_web.StoryWebActivity;
import com.example.jonguk.nyttest.utils.activity.BaseActivity;

import java.util.List;

import butterknife.BindView;
import rx.Subscription;

public class StoryListActivity extends BaseActivity {

    private static final String TAG = "StoryListActivity";

    @BindView(R.id.coordinator_layout)
    CoordinatorLayout mCoordinatorLayout;
    @BindView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout mRefreshLayout;
    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;
    @BindView(R.id.loading_view)
    ProgressBar mLoadingView;

    private StoryListAdapter mAdapter;

    private AbsStoryListViewHolder.OnItemClickListener mItemClickListener = position -> {
        StoryJson storyJson = mAdapter.getItem(position);
        if (storyJson != null) {
//            startActivity(StoryActivity.createArguments(StoryListActivity.this, storyJson));
            startActivity(StoryWebActivity.createArguments(StoryListActivity.this, storyJson.url));
            overridePendingTransition(R.anim.slide_right_in, R.anim.fade_out);
        }
    };
    private Subscription mStoryRequestSubscription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_list);
        mRecyclerView.setItemAnimator(null);
        mRecyclerView.setLayoutManager(
                new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        mAdapter = new StoryListAdapter(mItemClickListener);
        mRecyclerView.setAdapter(mAdapter);

        mRefreshLayout.setOnRefreshListener(this::requestStories);

        requestStories();
    }

    private void requestStories() {
        if (!mRefreshLayout.isRefreshing()) {
            showLoadingView();
        }
        if (mStoryRequestSubscription != null && !mStoryRequestSubscription.isUnsubscribed()) {
            mStoryRequestSubscription.unsubscribe();
        }
        mStoryRequestSubscription = StoryListRequest.getStoryList()
                .takeUntil(destroySignal())
                .subscribe(storyListJson -> {
                    hideLoadingView();
                    List<StoryJson> results = storyListJson.results;
                    if (results == null || results.size() == 0) {
                        showRetryButton();
                    } else {
                        mAdapter.initItems(results);
                    }
                }, err -> {
                    hideLoadingView();
                    showRetryButton();
                });
    }

    private void showRetryButton() {
        showSnackBar(mCoordinatorLayout, "불러오기 실패", "재시도", v -> requestStories());
    }

    private void showLoadingView() {
        if (mLoadingView != null) {
            mLoadingView.setVisibility(View.VISIBLE);
        }
    }

    private void hideLoadingView() {
        if (mLoadingView != null) {
            mLoadingView.setVisibility(View.GONE);
        }
        if (mRefreshLayout.isRefreshing()) {
            mRefreshLayout.setRefreshing(false);
        }
    }

}