package com.omnify.hire.Activity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;

import com.omnify.hire.R;
import com.omnify.hire.Utils.LightTextView;

/**
 * Created by user on 22-Sep-17.
 */

abstract public class OmnifySingleFragmentActivity extends OmnifyActivity {

    protected abstract Fragment createFragment();

    protected abstract int getContainerID();

    protected abstract boolean visibleToolBar();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResourceID());
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN
                | WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE
                | WindowManager.LayoutParams.SOFT_INPUT_STATE_UNCHANGED);
        lightTextView = (LightTextView) findViewById(R.id.toolbar_title_regular);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setVisibility(View.GONE);
        if (visibleToolBar()) {
            toolbar.setVisibility(View.VISIBLE);
            handleToolbar();
            setToolbarTitle();
        }
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(getContainerID());
        if (fragment == null) {
            fragment = createFragment();
            fm.beginTransaction()
                    .add(getContainerID(), fragment)
                    .commit();
        }
    }


}
