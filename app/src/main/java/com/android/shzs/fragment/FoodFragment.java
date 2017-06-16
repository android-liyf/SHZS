package com.android.shzs.fragment;

import android.widget.ImageView;

import com.android.shzs.R;
import com.android.shzs.base.BaseFragment;
import com.android.shzs.widget.BannerViewGroup;

import butterknife.BindView;


/**
 * Created by yanfeng on 2017/6/15.
 */

public class FoodFragment extends BaseFragment {
    @BindView(R.id.banner_vg)
    BannerViewGroup bannerVg;
    private int[] banners=new int[]{
            R.drawable.banner1,
            R.drawable.banner2,
            R.drawable.banner3
    };

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_food;
    }

    @Override
    protected void initView() {
        super.initView();

        for(int i=0;i<banners.length;i++){
            ImageView bannerImage=new ImageView(mContext);
            bannerImage.setImageResource(banners[i]);
            bannerVg.addView(bannerImage);
        }
    }


}
