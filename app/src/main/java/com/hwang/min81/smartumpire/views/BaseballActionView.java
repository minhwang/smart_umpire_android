package com.hwang.min81.smartumpire.views;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import com.hwang.min81.smartumpire.BaseballActionPager;
import com.hwang.min81.smartumpire.R;

import java.util.List;

/**
 * Created by hwangmin on 2016. 1. 27..
 */
public class BaseballActionView extends PopupWindow implements ViewPager.OnPageChangeListener, View.OnClickListener {
    private BaseballActionViewPager baseballActionViewPager;
    private int currentPagerPosition;
    private View[] anchors = new View[BaseballActionPager.values().length];
    private View.OnClickListener performActionListener;
    private View.OnClickListener restoreActionListener;

    public BaseballActionView(View contentView) {
        super(contentView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        this.setAnimationStyle(-1);
        this.baseballActionViewPager = new BaseballActionViewPager(contentView.getContext());
        this.baseballActionViewPager.setAdapter(new BaseballActionPagerAdapter());
        this.baseballActionViewPager.addOnPageChangeListener(this);
        ((RelativeLayout)contentView.findViewById(R.id.action_pager_layout)).addView(this.baseballActionViewPager);
        contentView.findViewById(R.id.ivClosePopup).setOnClickListener(this);
    }

    public void setOnPerformActionListener(View.OnClickListener listener) {
        this.performActionListener = listener;
    }

    public void setOnRestoreActionListener(View.OnClickListener listener) {
        this.restoreActionListener = listener;
    }

    public void setAnchor(BaseballActionPager actionPager, View anchor) {
        this.anchors[actionPager.getPagePosition()] = anchor;
    }

    public void showAbove(BaseballActionPager pager) {
        this.baseballActionViewPager.setCurrentItem(pager.getPagePosition());
        int statusBarHeight = (int)(getContentView().getResources().getDisplayMetrics().density * 24);
        this.showAtLocation(this.anchors[pager.getPagePosition()], Gravity.NO_GRAVITY, 0, statusBarHeight);
    }
    public View getCurrentAnchor() {
        return this.anchors[this.currentPagerPosition];
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        locateIndicator();
    }

    @Override
    public void onPageSelected(int position) {
        this.currentPagerPosition = position;
    }

    public void locateIndicator() {
        View indicator = getContentView().findViewById(R.id.ivPagerIndicator);

        int loc[] = new int[2];
        getCurrentAnchor().getLocationOnScreen(loc);
        int expectedX = loc[0] + getCurrentAnchor().getWidth() / 2 - indicator.getWidth() / 2;

        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        lp.setMargins(expectedX, 0, 0, 0);
        indicator.setLayoutParams(lp);
    }

    @Override
    public void onPageScrollStateChanged(int state) {
    }

    private int calculatePagerHeight() {
        View contentView = getContentView();

        int titleHeight = contentView.findViewById(R.id.title_layout).getMeasuredHeight();
        int statusBarHeight = (int)(getContentView().getResources().getDisplayMetrics().density * 24);
        int indicatorHeight = contentView.findViewById(R.id.ivPagerIndicator).getMeasuredHeight();

        int loc[] = new int[2];
        getCurrentAnchor().getLocationOnScreen(loc);

        return loc[1] - titleHeight - indicatorHeight - statusBarHeight;
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.ivClosePopup) {
            dismiss();
        }
    }

    class BaseballActionPagerAdapter extends PagerAdapter {
        @Override
        public int getCount() {
            return BaseballActionPager.values().length;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View)object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            int layoutId = BaseballActionPager.values()[position].getResId();
            LayoutInflater inflater = LayoutInflater.from(container.getContext());
            ViewGroup layout = (ViewGroup)inflater.inflate(layoutId, container, false);
            container.addView(layout);

            View contentView = getContentView();
            contentView.findViewById(R.id.btnPerformStrike).setOnClickListener(performActionListener);
            contentView.findViewById(R.id.btnPerformBall).setOnClickListener(performActionListener);

            return layout;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }
    }

    class BaseballActionViewPager extends ViewPager {
        @Override
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            heightMeasureSpec = MeasureSpec.makeMeasureSpec(calculatePagerHeight(), MeasureSpec.EXACTLY);
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            locateIndicator();
        }
        public BaseballActionViewPager(Context context) {
            super(context);
        }
    }
}
