package com.musa.raffi.me_test_crispy_chainsaw;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Asus on 9/29/2016.
 */

public class ContentPagerAdapter extends FragmentPagerAdapter {
    String[] mContent;
    int mNumPages;

    public ContentPagerAdapter(FragmentManager fm, String[] content, int numPages) {
        super(fm);
        mContent = content;
        mNumPages = numPages;
    }

    @Override
    public Fragment getItem(int position) {
        return ContentFragment.newInstance(mContent[position]);
    }

    @Override
    public int getCount() {
        return mNumPages;
    }
}
