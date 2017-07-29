package com.example.ibaou.myapplication.fragments;

/**
 * Created by ibaou on 7/29/2017.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ibaou.myapplication.R;

public class MyRequestTabFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_myrequest_tab, container, false);
    }
}