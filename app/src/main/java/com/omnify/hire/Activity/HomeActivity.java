package com.omnify.hire.Activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.omnify.hire.Fragment.RandomNumberFragment;
import com.omnify.hire.R;

public class HomeActivity extends OmnifySingleFragmentActivity {


    @Override
    protected int getLayoutResourceID() {
        return R.layout.activity_home;
    }

    @Override
    protected String setTitleForToolbar() {
        return "Home Activity";
    }

    @Override
    protected Fragment createFragment() {
        return RandomNumberFragment.getInstance();
    }

    @Override
    protected int getContainerID() {
        return R.id.container;
    }

    @Override
    protected boolean visibleToolBar() {
        return true;
    }
}
//tshirt ....
