package com.example.kylinarm.lazyfragmenttest;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends AppCompatActivity {

    @InjectView(R.id.vp_content)
    ViewPager vpContent;

    private ArrayList<Fragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        initView();
    }

    private void initView(){
        getFragments();
        vpContent.setOffscreenPageLimit(3);
        vpContent.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public int getCount() {
                return fragments.size();
            }

            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }
        });
    }

    private ArrayList<Fragment> getFragments(){
        fragments = new ArrayList<>();
        fragments.add(TestFragment.newInstance("页面一"));
        fragments.add(TestFragment.newInstance("页面二"));
        fragments.add(TestFragment.newInstance("页面三"));
        return fragments;
    }

}
