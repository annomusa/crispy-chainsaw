package com.musa.raffi.me_test_crispy_chainsaw;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;
    static final int NUM_PAGES = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);

        configViews();
    }

    private void configViews() {
        for (int i=0;i<NUM_PAGES;i++)
            tabLayout.addTab(tabLayout.newTab());

        switchFragment(0);
        tabLayout.addOnTabSelectedListener(tabListener);
//        addDivider();
    }

    private void addDivider(){
        for (int i=0;i<NUM_PAGES;i++){
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            RelativeLayout relativeLayout = (RelativeLayout)
                    LayoutInflater.from(this).inflate(R.layout.tab_layout, tabLayout, false);
            assert tab != null;
            tab.setCustomView(relativeLayout);
            tab.select();
        }
    }


    TabLayout.OnTabSelectedListener tabListener = new TabLayout.OnTabSelectedListener() {
        @Override
        public void onTabSelected(TabLayout.Tab tab) {
            switchFragment(tab.getPosition());
        }

        @Override
        public void onTabUnselected(TabLayout.Tab tab) {

        }

        @Override
        public void onTabReselected(TabLayout.Tab tab) {

        }
    };

    private void switchFragment(int position){
        Fragment fragment = null;
        String fragmentId = "";
        Bundle args = new Bundle();

        switch (position){
            case 0:
                fragmentId = "First";
                args.putString("pages", "A B C");
                break;
            case 1:
                fragmentId = "Second";
                args.putString("pages", "D E");
                break;
            case 2:
                fragmentId = "Third";
                args.putString("pages", "F");
        }
        fragment = new ViewPagerFragment();
        fragment.setArguments(args);

        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction().replace(R.id.fragment_container, fragment, fragmentId).commit();
    }
}
