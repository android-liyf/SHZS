package com.android.shzs.statusbar;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

/**
 * Created by yf on 2017/4/18.
 * 状态栏兼容
 */

public class StatusBarCompat {
    public static void compat(Activity activity ) {
        ViewGroup contentFrameLayout = (ViewGroup) activity.findViewById(Window.ID_ANDROID_CONTENT);
        View parentView = contentFrameLayout.getChildAt(0);
        if (parentView != null && Build.VERSION.SDK_INT >= 14) {
            parentView.setFitsSystemWindows(false);
        }
    }
}
