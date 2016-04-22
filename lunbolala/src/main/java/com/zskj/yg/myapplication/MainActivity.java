package com.zskj.yg.myapplication;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity {

    private ViewPager vp;
    private LinearLayout ll;
    private List<ImageView> mImages;

    private Handler h = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if (msg.what==1){
                h.removeMessages(0);
                return;
            }

            vp.setCurrentItem(vp.getCurrentItem()+1);
            h.sendEmptyMessageDelayed(0,2000);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        initData();
        vp.setAdapter(new pagerAda(mImages));
        vp.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        h.sendEmptyMessage(1);
                        break;
                    case MotionEvent.ACTION_UP:
                        h.sendEmptyMessageDelayed(0,2000);
                        break;
                }
                return false;
            }
        });
        vp.setCurrentItem(Integer.MAX_VALUE/2-3);
        h.sendEmptyMessageDelayed(0,2000);
        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position%mImages.size()){
                    case 0:
                        ll.getChildAt(4).setBackgroundResource(R.drawable.dot_write);
                        ll.getChildAt(0).setBackgroundResource(R.drawable.dot_red);
                        ll.getChildAt(1).setBackgroundResource(R.drawable.dot_write);
                        break;
                    case 1:
                        ll.getChildAt(0).setBackgroundResource(R.drawable.dot_write);
                        ll.getChildAt(1).setBackgroundResource(R.drawable.dot_red);
                        ll.getChildAt(2).setBackgroundResource(R.drawable.dot_write);
                        break;
                    case 2:
                        ll.getChildAt(1).setBackgroundResource(R.drawable.dot_write);
                        ll.getChildAt(2).setBackgroundResource(R.drawable.dot_red);
                        ll.getChildAt(3).setBackgroundResource(R.drawable.dot_write);
                        break;
                    case 3:
                        ll.getChildAt(2).setBackgroundResource(R.drawable.dot_write);
                        ll.getChildAt(3).setBackgroundResource(R.drawable.dot_red);
                        ll.getChildAt(4).setBackgroundResource(R.drawable.dot_write);
                        break;
                    case 4:
                        ll.getChildAt(3).setBackgroundResource(R.drawable.dot_write);
                        ll.getChildAt(4).setBackgroundResource(R.drawable.dot_red);
                        ll.getChildAt(0).setBackgroundResource(R.drawable.dot_write);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void initData() {
        ImageView v = new ImageView(this);
        v.setImageResource(R.mipmap.aia);

        ImageView b = new ImageView(this);
        b.setImageResource(R.mipmap.ddd);

        ImageView d = new ImageView(this);
        d.setImageResource(R.mipmap.ghhgh);

        ImageView l = new ImageView(this);
        l.setImageResource(R.mipmap.jedjh);

        ImageView u = new ImageView(this);
        u.setImageResource(R.mipmap.lll);

        mImages.add(v);
        mImages.add(b);
        mImages.add(d);
        mImages.add(l);
        mImages.add(u);
    }


    private void init() {
        vp = (ViewPager) findViewById(R.id.VP);
        ll = (LinearLayout) findViewById(R.id.ll_dots);
        mImages = new ArrayList<ImageView>();
    }

}
