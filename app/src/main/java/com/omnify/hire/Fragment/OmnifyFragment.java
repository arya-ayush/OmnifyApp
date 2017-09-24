package com.omnify.hire.Fragment;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.omnify.hire.R;
import com.omnify.hire.Utils.LightTextView;

import butterknife.ButterKnife;

/**
 * Created by user on 22-Sep-17.
 */

abstract public class OmnifyFragment extends Fragment {

    protected Toolbar toolbar;
    protected LightTextView lightTextView;



    public OmnifyFragment() {

    }

    @LayoutRes
    abstract protected int getLayoutResId();

    abstract protected String setToolbarTitle();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutResId(), container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    protected String getStringFromEditText(EditText editText) {
        return editText.getText().toString().trim();
    }


    protected void replaceFragment(Fragment launchingFragment, int containerId, Fragment currentFragmentObject) {
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.hide(currentFragmentObject);
        transaction.add(containerId, launchingFragment);
        transaction.commit();
    }

    protected void setToolBarTitleOnFragment() {
        Toolbar toolbar = (Toolbar) getView().getRootView().findViewById(R.id.toolbar);
        View view;
        for (int i = 0; i < toolbar.getChildCount(); i++) {
            view = toolbar.getChildAt(i);
            if (view instanceof LightTextView) {
                ((LightTextView) view).setText(setToolbarTitle());
                break;
            }
        }
    }

    protected void setToolBarTitleOnFragment(String title) {
        Toolbar toolbar = (Toolbar) getView().getRootView().findViewById(R.id.toolbar);
        View view;
        for (int i = 0; i < toolbar.getChildCount(); i++) {
            view = toolbar.getChildAt(i);
            if (view instanceof LightTextView) {
                ((LightTextView) view).setText(title);
                break;
            }
        }
    }


    protected int getFragmentContainer() {
        int containerID = ((ViewGroup) getView().getParent()).getId();
        return containerID;
    }




}
