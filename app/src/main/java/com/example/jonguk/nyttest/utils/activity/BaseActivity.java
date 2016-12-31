package com.example.jonguk.nyttest.utils.activity;

import android.graphics.Color;
import android.support.annotation.LayoutRes;
import android.support.annotation.StringRes;
import android.support.design.widget.Snackbar;
import android.view.View;
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

    protected void showSnackbar(View view, String msg) {
        Snackbar.make(view, msg, Snackbar.LENGTH_LONG).show();
    }

    protected void showSnackBar(View view, String msg, String actionString, View.OnClickListener listener) {
        Snackbar.make(view, msg, Snackbar.LENGTH_INDEFINITE)
                .setActionTextColor(Color.RED)
                .setAction(actionString, listener).show();
    }

    protected String getStringWithoutException(@StringRes int resId) {
        try {
            return getString(resId);
        } catch (Exception e) {
            return "(null)";
        }
    }
}
