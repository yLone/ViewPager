package com.zskj.yg.myapplication;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.view.*;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2016/4/21.
 */
public class pagerAda extends android.support.v4.view.PagerAdapter {

    private ArrayList<ImageView> mImageViews;

    public pagerAda(List<ImageView> mImageViews) {
        this.mImageViews = (ArrayList<ImageView>) mImageViews;
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        position %= mImageViews.size();

        ImageView view = mImageViews.get(position);
        container.addView(view);
        return view;
    }
}
