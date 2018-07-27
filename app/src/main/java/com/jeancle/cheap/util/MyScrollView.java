package com.jeancle.cheap.util;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;

/**
 * Created by Administrator on 2017-10-15.
 */

public class MyScrollView extends ScrollView {
    GestureDetector gestureDetector;
    View.OnTouchListener onTouchListener;


    public MyScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
        // 添加了一个手势选择器
        gestureDetector = new GestureDetector(new Yscroll());
        setFadingEdgeLength(0);
    }


    public boolean onInterceptTouchEvent(MotionEvent ev) {
// TODO Auto-generated method stub
// return super.onInterceptTouchEvent(ev);
        return super.onInterceptTouchEvent(ev) && gestureDetector.onTouchEvent(ev);

    }

    class Yscroll extends GestureDetector.SimpleOnGestureListener {

        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2,
                                float distanceX, float distanceY) {
//控制手指滑动的距离
            if (Math.abs(distanceY) >= Math.abs(distanceX)) {
                return true;
            }
            return false;
        }

    }
}