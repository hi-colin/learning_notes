package com.example.mybookapplication.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mybookapplication.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PageFourFragment extends Fragment {

    public PageFourFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.vp_fourpage, container, false);
        TextView tv_four = view.findViewById(R.id.tv_four);
        tv_four.setText("PageFourFragment");

        return view;
    }



}
