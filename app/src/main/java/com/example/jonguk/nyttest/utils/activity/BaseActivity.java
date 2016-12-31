package com.example.jonguk.nyttest.utils.activity;

import android.support.annotation.LayoutRes;
import android.support.annotation.StringRes;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Jonguk on 2016. 12. 31..
 */

public class BaseActivity extends RxActivity {

    private Unbinder mUnbinder;

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        mUnbinder = ButterKnife.bind(this);
    }

    @Override
    protected void onDestroy() {
        if (mUnbinder != null) {
            mUnbinder.unbind();
        }
        super.onDestroy();
    }

    protected void showToast(@StringRes int resId) {
        showToast(getString(resId));
    }

    protected void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    protected String getStringWithoutException(@StringRes int resId) {
        try {
            return getString(resId);
        } catch (Exception e) {
            return "(null)";
        }
    }
}
