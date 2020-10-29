package com.example.mybookapplication.activity;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.example.mybookapplication.R;
import com.example.mybookapplication.adapter.FragmentViewPageAdapter;
import com.example.mybookapplication.fragment.PageFourFragment;
import com.example.mybookapplication.fragment.PageOneFragment;
import com.example.mybookapplication.fragment.PageThreeFragment;
import com.example.mybookapplication.fragment.PageTwoFragment;

import java.util.ArrayList;
import java.util.List;

public class BottomTabsActivity extends FragmentActivity implements View.OnClickListener {


    // 原文链接： https://blog.csdn.net/LABLENET/article/details/48542461


    private ViewPager vp_fragment_viewpage;
    private LinearLayout linear_shouye, linear_xinxi, linear_gongju, linear_wo;
    private ImageButton img_shouye, img_xinxi, img_gongju, img_wo;
    private View one_page, two_page, three_page, four_page;
    private List<Fragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_and_viewpage);
        fragments = new ArrayList<Fragment>();
        InitView();
    }

    private void InitView() {
        vp_fragment_viewpage = findViewById(R.id.vp_fragment_viewpage);
        linear_shouye = findViewById(R.id.linear_shouye);
        linear_xinxi = findViewById(R.id.linear_xinxi);
        linear_gongju = findViewById(R.id.linear_gongju);
        linear_wo = findViewById(R.id.linear_wo);

        img_shouye = findViewById(R.id.img_shouye);
        img_xinxi = findViewById(R.id.img_xinxi);
        img_gongju = findViewById(R.id.img_gongju);
        img_wo = findViewById(R.id.img_wo);

        PageOneFragment pageOneFragment = new PageOneFragment();
        fragments.add(pageOneFragment);
        PageTwoFragment pageTwoFragment = new PageTwoFragment();
        fragments.add(pageTwoFragment);
        PageThreeFragment pageThreeFragment = new PageThreeFragment();
        fragments.add(pageThreeFragment);
        PageFourFragment pageFourFragment = new PageFourFragment();
        fragments.add(pageFourFragment);

        FragmentViewPageAdapter fragmentViewPageAdapter = new FragmentViewPageAdapter(
                getSupportFragmentManager(), fragments);

        linear_shouye.setOnClickListener(this);
        linear_xinxi.setOnClickListener(this);
        linear_gongju.setOnClickListener(this);
        linear_wo.setOnClickListener(this);

        vp_fragment_viewpage.setOnPageChangeListener(new vpOnChangeListener());

    }

    @Override
    public void onClick(View v) {
        ResetTabsImg();
        switch (v.getId()) {
            case R.id.linear_shouye:
                SetTabsSelectedImg(0);
                break;
            case R.id.linear_xinxi:
                SetTabsSelectedImg(1);
                break;
            case R.id.linear_gongju:
                SetTabsSelectedImg(2);
                break;
            case R.id.linear_wo:
                SetTabsSelectedImg(3);
                break;
        }
    }

    public void ResetTabsImg() {
        img_shouye.setImageResource(R.mipmap.ic_launcher_round);
        img_xinxi.setImageResource(R.mipmap.ic_launcher_round);
        img_gongju.setImageResource(R.mipmap.ic_launcher_round);
        img_wo.setImageResource(R.mipmap.ic_launcher_round);
    }

    public void SetTabsSelectedImg(int i) {
        switch (i) {
            case 0:
                img_shouye.setImageResource(R.mipmap.ic_launcher);
                break;
            case 1:
                img_xinxi.setImageResource(R.mipmap.ic_launcher);
                break;
            case 2:
                img_gongju.setImageResource(R.mipmap.ic_launcher);
                break;
            case 3:
                img_wo.setImageResource(R.mipmap.ic_launcher);
                break;
        }

        vp_fragment_viewpage.setCurrentItem(i);
    }

    private class vpOnChangeListener implements ViewPager.OnPageChangeListener {

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            ResetTabsImg();
            SetTabsSelectedImg(position);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }
}
