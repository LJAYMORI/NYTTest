package com.example.jonguk.nyttest.screen.story_web;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.example.jonguk.nyttest.R;
import com.example.jonguk.nyttest.json.StoryJson;
import com.example.jonguk.nyttest.utils.activity.BaseActivity;

import butterknife.BindView;

/**
 * Created by Jonguk on 2016. 12. 31..
 */

public class StoryWebActivity extends BaseActivity {

    public static final String ARG_STORY_JSON = "story_json";

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.web_view)
    WebView mWebView;
    @BindView(R.id.loading_view)
    ProgressBar mLoadingView;

    private StoryJson mStoryJson;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_web);

        if (initArgs()) {
            initActionBar();
            initWebView();
        }
    }

    @Override
    public void onBackPressed() {
        if (mWebView != null) {
            if (mWebView.canGoBack()) {
                mWebView.goBack();
                return;
            }
        }
        super.onBackPressed();
    }

    private void setSubTitle(String subTitle) {
        if (mToolbar != null) {
            mToolbar.setSubtitle(subTitle);
        }
    }

    private void setTitle(String title) {
        if (mToolbar != null) {
            mToolbar.setTitle(title);
        }
    }

    private void initWebView() {
        WebViewClient client = new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                showLoadingView();
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                hideLoadingView();
                setSubTitle(url);
            }
        };
        WebChromeClient chromeClient = new WebChromeClient() {
            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
                setTitle(title);
            }
        };

        mWebView.setWebViewClient(client);
        mWebView.setWebChromeClient(chromeClient);
        WebSettings settings = mWebView.getSettings();
        settings.setPluginState(WebSettings.PluginState.ON);
        settings.setUseWideViewPort(true);
        settings.setDefaultZoom(WebSettings.ZoomDensity.MEDIUM);
        settings.setBuiltInZoomControls(true);
        settings.setSupportZoom(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setSupportMultipleWindows(true);
        settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        settings.setAllowFileAccess(true);
        settings.setDomStorageEnabled(true);
        settings.setJavaScriptEnabled(true);
        settings.setAppCacheEnabled(true);
        settings.setDisplayZoomControls(false);
        mWebView.loadUrl(mStoryJson.url);
    }

    private void initActionBar() {
        if (mToolbar != null) {
            mToolbar.setTitle(mStoryJson.url);
            mToolbar.setNavigationIcon(R.drawable.ic_close_grey);
            mToolbar.setNavigationOnClickListener(v -> finish());
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

    private void showLoadingView() {
        if (mLoadingView != null) {
            mLoadingView.setVisibility(View.VISIBLE);
        }
    }

    private void hideLoadingView() {
        if (mLoadingView != null) {
            mLoadingView.setVisibility(View.GONE);
        }
    }

    public static Intent createArguments(Context context, StoryJson storyJson) {
        Intent intent = new Intent(context, StoryWebActivity.class);
        intent.putExtra(ARG_STORY_JSON, storyJson);
        return intent;
    }
}
