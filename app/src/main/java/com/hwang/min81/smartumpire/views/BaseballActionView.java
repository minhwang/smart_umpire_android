package com.hwang.min81.smartumpire.views;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;

import com.hwang.min81.smartumpire.BaseballActionPager;
import com.hwang.min81.smartumpire.R;

/**
 * Created by hwangmin on 2016. 1. 27..
 */
public class BaseballActionView {
    private View popupView;
    private PopupWindow popupWindow;
    ViewPager baseballActioinViewPager;

    public BaseballActionView(Context context) {
        this.popupView = LayoutInflater.from(context).inflate(R.layout.baseball_action_view, null);
        this.popupWindow = new PopupWindow(this.popupView, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        this.popupWindow.setAnimationStyle(-1);

        this.baseballActioinViewPager = (ViewPager)this.popupView.findViewById(R.id.vpBaseballAction);
        baseballActioinViewPager.setAdapter(new BaseballActionPagerAdapter(context));
    }

    public void show(BaseballActionPager pager, View anchor) {
        this.baseballActioinViewPager.setCurrentItem(pager.getPagePosition());
        this.popupWindow.showAsDropDown(anchor, 0, -500);
    }

    class BaseballActionPagerAdapter extends PagerAdapter {
        private Context context;

        public BaseballActionPagerAdapter(Context ctx) {
            this.context = ctx;
        }

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
            LayoutInflater inflater = LayoutInflater.from(this.context);
            ViewGroup layout = (ViewGroup)inflater.inflate(layoutId, container, false);
            container.addView(layout);

            return layout;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }
    }
}
