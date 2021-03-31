package com.example.smarttrashcanmap;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class LoginAdapter1 extends FragmentPagerAdapter {

    private Context context;
    int totalTabs;


    public LoginAdapter1(FragmentManager fn, Context context, int totalTabs) {
        super(fn);
        this.context = context;
        this.totalTabs = totalTabs;

    }

    @Override
    public int getCount() {
        return totalTabs;
    }

    public Fragment getItem(int position) {
        switch (position) {


            case 0:
                LoginTabFragment1 loginTabFragment1 = new LoginTabFragment1();
                return loginTabFragment1;
            case 1:
                SignupTabFragment1 signupTabFragment1 = new SignupTabFragment1();
                return signupTabFragment1;
            default:
                return null;


        }
    }
}
