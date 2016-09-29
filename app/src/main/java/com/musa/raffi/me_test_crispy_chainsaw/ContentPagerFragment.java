package com.musa.raffi.me_test_crispy_chainsaw;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Asus on 9/29/2016.
 */

public class ContentPagerFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.content_pager, container, false);
        TextView contentChar = (TextView) view.findViewById(R.id.content_char);

        contentChar.setText(getArguments().getString("content"));
        return view;
    }

    public static ContentPagerFragment newInstance(String content){
        ContentPagerFragment contentFragment = new ContentPagerFragment();
        Bundle args = new Bundle();
        args.putString("content", content);
        contentFragment.setArguments(args);
        return contentFragment;
    }
}
