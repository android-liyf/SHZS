package com.android.shzs.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

/**首页轮播图核心类
 * Created by yanfeng on 2017/6/16.
 */

public class BannerViewGroup extends ViewGroup{
    private int childCount;
    private int childWidth;
    private int childHeight;
    private int x;//第一次按下的横坐标，每一次移动之前位置的横坐标
    private int index;//每张图片的索引


    public BannerViewGroup(Context context) {
        super(context);
    }

    public BannerViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BannerViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        childCount =getChildCount();
        if(childCount==0){
           setMeasuredDimension(0,0);
        }else{
            measureChildren(widthMeasureSpec,heightMeasureSpec);
            View view=getChildAt(0);
            childWidth=view.getMeasuredWidth();
            childHeight=view.getMeasuredHeight();
            //根据子试图的宽高和个数来算出父试图的宽高
            setMeasuredDimension(childWidth*childCount,childHeight);
        }
    }

    /**
     * 集成ViewGroup必须实现onLayout
     */
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        if(changed){
            int leftMargin=0;
            for(int i=0;i<childCount;i++){
                View view=getChildAt(i);
                view.layout(leftMargin,0,leftMargin+childWidth,childHeight);
                leftMargin  +=  childWidth;
            }
        }
    }

    /**
     *
     * @param ev
     * @return  true表示自身拦截处理事件，false则向下传递
     */
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return false;
    }

    /**
     *
     * @param event
     * @return true表示事件处理完成
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                x=(int)event.getX();
            break;
            case MotionEvent.ACTION_MOVE:
                int moveX=(int)event.getX();
                int distance=moveX-x;
                scrollBy(-distance,0);
                x=moveX;
                break;
            case MotionEvent.ACTION_UP:
                int scrollX=getScrollX();
                index=(scrollX+childWidth/2)/childWidth;
                if(index<0){//滑动到了最左边
                    index=0;
                }else if(index>childCount-1){//滑动到了最右边
                    index=childCount-1;
                }
                scrollTo(index*childWidth,0);
                break;
        }
        return true;
    }
}
