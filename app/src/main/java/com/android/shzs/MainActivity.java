package com.android.shzs;

import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.android.shzs.base.BaseActivity;

import butterknife.BindView;


public class MainActivity extends BaseActivity {


    @BindView(R.id.tab_trip_image)
    ImageButton tabTripImage;
    @BindView(R.id.tab_trip_layout)
    LinearLayout tabTripLayout;
    @BindView(R.id.tab_food_image)
    ImageButton tabFoodImage;
    @BindView(R.id.tab_food_layout)
    LinearLayout tabFoodLayout;



    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        super.initView();
        tabFoodImage.setImageResource(R.drawable.tab_food_pressed);
    }


}
