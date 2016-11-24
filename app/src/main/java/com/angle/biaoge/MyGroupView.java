package com.angle.biaoge;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * Created by Administrator on 2016/11/24 0024.
 */

public class MyGroupView extends ViewGroup{
    public MyGroupView(Context context) {
        super(context);
    }

    public MyGroupView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyGroupView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int maxW=getResources().getDisplayMetrics().widthPixels-getPaddingLeft()-getPaddingRight();
        int lineCount=0;
        int sumW=0;
        int i=0;
        for (i=0;i<getChildCount();i++){
            View view=getChildAt(i);
            view.measure(0,0);
            int w=view.getMeasuredWidth();
            int h=view.getMeasuredHeight();
            if(sumW<=maxW&&i%4!=0){
                view.layout(sumW,lineCount*h,sumW+w,lineCount*h+h);
                sumW+=w+10;
            }else{
                sumW=0;
                lineCount++;
                view.layout(sumW,lineCount*h,sumW+w,lineCount*h+h);
                sumW+=w+10;
            }
        }
    }
}
