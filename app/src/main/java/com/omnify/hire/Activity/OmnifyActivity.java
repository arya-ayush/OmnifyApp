package com.omnify.hire.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.omnify.hire.R;
import com.omnify.hire.Utils.LightTextView;


abstract public class OmnifyActivity extends AppCompatActivity {

    protected LightTextView lightTextView;

    public Toolbar toolbar;

    abstract protected int getLayoutResourceID();

    abstract protected String setTitleForToolbar();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResourceID());
        lightTextView = (LightTextView) findViewById(R.id.toolbar_title_regular);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        handleToolbar();
        setToolbarTitle();
    }


    protected final void handleToolbar() {
        setSupportActionBar(toolbar);
    }

    protected final void setToolbarTitle() {
        if (lightTextView != null) {
            lightTextView.setText(setTitleForToolbar());
        }
    }

}
