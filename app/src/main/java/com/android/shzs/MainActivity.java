package com.android.shzs;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.android.shzs.base.BaseActivity;
import com.android.shzs.fragment.FoodFragment;
import com.android.shzs.fragment.TripFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;


public class MainActivity extends BaseActivity{


    @BindView(R.id.tab_trip_image)
    ImageButton tabTripImage;
    @BindView(R.id.tab_trip_layout)
    LinearLayout tabTripLayout;
    @BindView(R.id.tab_food_image)
    ImageButton tabFoodImage;
    @BindView(R.id.tab_food_layout)
    LinearLayout tabFoodLayout;
    @BindView(R.id.main_viewpager)
    ViewPager mainViewpager;
    private FragmentPagerAdapter fragmentPagerAdapter;
    private List<Fragment> fragmentList;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        super.initView();
        fragmentList=new ArrayList<Fragment>();
        FoodFragment foodFragment=new FoodFragment();
        TripFragment tripFragment=new TripFragment();
        fragmentList.add(tripFragment);
        fragmentList.add(foodFragment);
        fragmentPagerAdapter=new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragmentList.get(position);
            }

            @Override
            public int getCount() {
                return fragmentList.size();
            }
        };
        mainViewpager.setAdapter(fragmentPagerAdapter);
        setSelect(0);

    }


    @Override
    protected void initListener() {
        super.initListener();
        mainViewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                setTab(position);
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }



    private void setTab(int i) {
        setImageNormal();
        switch (i){
            case 0:
                tabTripImage.setImageResource(R.drawable.tab_trip_pressed);
                break;
            case 1:
                tabFoodImage.setImageResource(R.drawable.tab_food_pressed);
                break;
        }
    }

    private void setImageNormal() {
        tabTripImage.setImageResource(R.drawable.tab_trip_normal);
        tabFoodImage.setImageResource(R.drawable.tab_food_normal);
    }
    private void setSelect(int i) {
        setTab(i);
        mainViewpager.setCurrentItem(i);
    }

    @OnClick({R.id.tab_trip_layout, R.id.tab_food_layout})
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tab_trip_layout:
                setSelect(0);
            break;

            case R.id.tab_food_layout:
                setSelect(1);
                break;
        }
    }
}
