package com.musa.raffi.me_test_crispy_chainsaw;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import static android.content.ContentValues.TAG;

/**
 * Created by Asus on 9/29/2016.
 */

public class ViewPagerFragment extends Fragment {
    int numPages;
    String[] content;
    ContentPagerAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String input = getArguments().getString("pages");
        Log.d(TAG, "onCreate: " + input);
        content = input.split(" ");
        numPages = content.length;
        adapter = new ContentPagerAdapter(getChildFragmentManager(), content, numPages);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.pager_container, container, false);

        ViewPager viewPager = (ViewPager) view.findViewById(R.id.pager);
        viewPager.setAdapter(adapter);

        return view;
    }
}
