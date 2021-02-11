package com.example.tabnavigation;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    //Inisilizing views
    TabLayout tab;
    ViewPager viewPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // connecting ids
        tab=findViewById(R.id.tab1);
        viewPage=findViewById(R.id.viewpager1);
        viewPage.setAdapter(new MypagerAdapter(getSupportFragmentManager()));
        tab.setupWithViewPager(viewPage);
        tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Toast.makeText(MainActivity.this,
                        "Selected : "+tab.getText().toString(), Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                Toast.makeText(MainActivity.this,
                        "Un-Selected : "+tab.getText().toString(), Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                Toast.makeText(MainActivity.this,
                        "Re-Selected : "+tab.getText().toString(), Toast.LENGTH_SHORT).show();

            }
        });
    }
    // For create a Fragment pager adapter class
    public  class MypagerAdapter extends FragmentPagerAdapter{

       String titles[]={"Chats","Status","Calls"};
        public MypagerAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            if (position==0){
                return  new ChatsFragment();
            }
            if (position==1){
                return new StatusFragment();
            }
            if (position==2){
                return  new CallsFragment();
            }
            return null;
        }

        @Override
        public int getCount() {
            return titles.length;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }
    }
}