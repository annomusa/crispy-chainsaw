package com.musa.raffi.me_test_crispy_chainsaw;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);

        tabLayout.addTab(tabLayout.newTab().setText("Tab 1"));
        tabLayout.addTab(tabLayout.newTab().setText("Tab 2"));
        tabLayout.addTab(tabLayout.newTab().setText("Tab 3"));

        switchFragment(0);

        tabLayout.addOnTabSelectedListener(tabListener);
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
