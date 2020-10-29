package com.example.mybookapplication.activity;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.blankj.utilcode.util.BarUtils;
import com.blankj.utilcode.util.ScreenUtils;
import com.example.mybookapplication.R;
import com.example.mybookapplication.fragment.TextFragment;
import com.jaeger.library.StatusBarUtil;
import com.yinglan.alphatabs.AlphaTabsIndicator;

import java.util.ArrayList;
import java.util.List;


public class TestActivity extends AppCompatActivity {

    private AlphaTabsIndicator alphaTabsIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);


        // 闪屏页效果（全屏）
//        ScreenUtils.setFullScreen(this);
        // 透明状态栏
//        BarUtils.transparentStatusBar(this);
        // 设置状态栏颜色
//        BarUtils.setStatusBarColor(this, getResources().getColor(R.color.colorPrimary));



        ViewPager mViewPager = findViewById(R.id.mViewPager);
        MainAdapter mainAdapter = new MainAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mainAdapter);
        mViewPager.addOnPageChangeListener(mainAdapter);

        alphaTabsIndicator = findViewById(R.id.alphaIndicator);
        alphaTabsIndicator.setViewPager(mViewPager);

    }


    private class MainAdapter extends FragmentPagerAdapter implements ViewPager.OnPageChangeListener{

        private List<Fragment> fragments = new ArrayList<>();
        private String[] titles = {"微信", "通信录", "发现", "我"};

        public MainAdapter(FragmentManager fm) {
            super(fm);
            fragments.add(TextFragment.newInstance(titles[0]));
            fragments.add(TextFragment.newInstance(titles[1]));
            fragments.add(TextFragment.newInstance(titles[2]));
            fragments.add(TextFragment.newInstance(titles[3]));
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }
}
