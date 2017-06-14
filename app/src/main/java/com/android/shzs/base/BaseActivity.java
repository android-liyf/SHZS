package com.android.shzs.base;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.android.shzs.statusbar.StatusBarCompat;
import com.android.shzs.statusbar.StatusBarFontHelper;

import butterknife.ButterKnife;


/**
 * Created by yf on 2017/4/18.
 */

/**
 * abstract修饰类，会使这个类成为一个抽象类，这个类将不能生成对象实例，
 * 但可以做为对象变量声明的类型，也就是编译时类型，抽象类就像当于一类的半成品，
 * 需要子类继承并覆盖其中的抽象方法
 */

public abstract class BaseActivity extends AppCompatActivity {

    protected Context mContext;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置屏幕方向为肖像方向，切换屏幕不会横屏
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        beforeSetContentView(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        AppManager.getAppManager().addActivity(this);
        mContext=this;
        afterSetContentView(savedInstanceState);
        StatusBarCompat.compat(this);
        StatusBarFontHelper.setStatusBarMode(this, true);
        initView();
        initData();
        initListener();
    }

    protected void beforeSetContentView(Bundle savedInstanceState) {}

    protected abstract int getLayoutId();

    protected void afterSetContentView(Bundle savedInstanceState) {}

    protected void initView() {}

    protected void initData() {}

    protected void initListener() {}

//    public void setToolbar(Toolbar mToolbar) {
//        setSupportActionBar(mToolbar);
//        if (getSupportActionBar() != null) {
//            //隐藏标题栏
//            getSupportActionBar().setDisplayShowTitleEnabled(false);
//        }
//    }



}
