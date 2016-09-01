package com.pffair.viewpagerwithleftandright;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    ViewPager mViewPager;

    RelativeLayout mViewPagerBox;

    private ViewPagerAdapter mViewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mViewPagerBox = (RelativeLayout) findViewById(R.id.rl_container);

        mViewPager.setOffscreenPageLimit(3);

        mViewPagerAdapter = new ViewPagerAdapter();
        mViewPager.setAdapter(mViewPagerAdapter);

        mViewPagerBox.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return mViewPager.dispatchTouchEvent(event);
            }
        });

    }

    public static class ViewPagerAdapter extends PagerAdapter {

        int pic[] = {R.drawable.p1,R.drawable.p2,R.drawable.p4,R.drawable.p5};

        @Override
        public int getCount() {
            return 4;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return object == view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position,
                Object object) {
            container.removeView((View) object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View view =  LayoutInflater.from(container.getContext()).inflate(R.layout.item,container,false);
            container.addView(view);
            ImageView imageView = (ImageView) view.findViewById(R.id.iv_pic);
            imageView.setBackgroundResource(pic[position]);
            return view;
        }
    }
}
