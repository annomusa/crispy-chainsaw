package com.musa.raffi.me_test_crispy_chainsaw;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;

/**
 * Created by Asus on 9/29/2016.
 */

public class ViewPagerFragment extends Fragment {
    int numPages;
    String[] content;
    ContentPagerAdapter adapter;
    ViewPager viewPager;
    LinearLayout dotsLayout;
    ArrayList<ImageView> dots;
    int height;
    int width;
    Resources res;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String input = getArguments().getString("pages");
        content = input.split(" ");
        numPages = content.length;
        adapter = new ContentPagerAdapter(getChildFragmentManager(), content, numPages);
        height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 18, getResources().getDisplayMetrics());
        width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 18, getResources().getDisplayMetrics());
        res = getResources();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.pager_container, container, false);
        dotsLayout = (LinearLayout) view.findViewById(R.id.dots);
        viewPager = (ViewPager) view.findViewById(R.id.pager);
        viewPager.setAdapter(adapter);
        addIndicator();
        return view;
    }

    public void addIndicator(){
        dots = new ArrayList<>();
        if (numPages == 1) return;
        for (int i=0;i<numPages;i++){
            ImageView dot = new ImageView(getActivity());
            int drawableId = (i == 0) ? (R.drawable.dot_selected):(R.drawable.dot_unselected);
            Drawable drawable = res.getDrawable(drawableId);
            dot.setImageDrawable(drawable);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(height, width);
            params.gravity = Gravity.CENTER_HORIZONTAL;
            params.setMargins(15,0,15,0);

            dotsLayout.addView(dot, params);
            dots.add(dot);
        }
        viewPager.addOnPageChangeListener(pageListener);
    }

    ViewPager.OnPageChangeListener pageListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            currentPage(position);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    public void currentPage(int position) {
        for(int i = 0; i < numPages; i++) {
            int drawableId = (i == position) ? (R.drawable.dot_selected):(R.drawable.dot_unselected);
            Drawable drawable = res.getDrawable(drawableId);
            dots.get(i).setImageDrawable(drawable);
        }
    }
}
