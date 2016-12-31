package com.example.jonguk.nyttest.screen.story_web;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.example.jonguk.nyttest.R;
import com.example.jonguk.nyttest.utils.activity.BaseActivity;

import butterknife.BindView;

/**
 * Created by Jonguk on 2016. 12. 31..
 */

public class StoryWebActivity extends BaseActivity {

//    public static final String ARG_STORY_JSON = "story_json";
    public static final String ARG_URL = "arg_url";

    @BindView(R.id.coordinator_layout)
    CoordinatorLayout mCoordinatorLayout;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.web_view)
    WebView mWebView;
    @BindView(R.id.loading_view)
    ProgressBar mLoadingView;

    private String mUrl;

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

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.fade_in, R.anim.slide_right_out);
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
                showLoadingView();
            }

            @Override
            public void onPageCommitVisible(WebView view, String url) {
                hideLoadingView();
                setSubTitle(url);
            }

            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                super.onReceivedError(view, request, error);
                showSnackBar(mCoordinatorLayout,
                        "", getStringWithoutException(R.string.retry), v -> requestUrl());
            }
        };
        WebChromeClient chromeClient = new WebChromeClient() {
            @Override
            public void onReceivedTitle(WebView view, String title) {
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

        requestUrl();
    }

    private void requestUrl() {
        if (mWebView != null) {
            mWebView.loadUrl(mUrl);
        }
    }

    private void initActionBar() {
        if (mToolbar != null) {
            mToolbar.setTitle(mUrl);
            mToolbar.setNavigationIcon(R.drawable.ic_close_grey);
            mToolbar.setNavigationOnClickListener(v -> finish());
        }
    }

    private boolean initArgs() {
//        mStoryJson = getIntent().getParcelableExtra(ARG_STORY_JSON);
        Intent intent = getIntent();
        if (intent != null) {
            mUrl = intent.getStringExtra(ARG_URL);
            if (!TextUtils.isEmpty(mUrl)) {
                return true;
            }
        }
        showToast("invalid argument");
        finish();
        return false;
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

    public static Intent createArguments(Context context, String url) {
        Intent intent = new Intent(context, StoryWebActivity.class);
        intent.putExtra(ARG_URL, url);
        return intent;
    }
}
