package com.example.ibaou.myapplication.adapters;

/**
 * Created by ibaou on 7/29/2017.
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.ibaou.myapplication.fragments.CashBuddiesTabFragment;
import com.example.ibaou.myapplication.fragments.MyRequestTabFragment;

public class HomeTabPagerAdapter extends FragmentStatePagerAdapter {

    int mNumOfTabs;

    public HomeTabPagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                MyRequestTabFragment tab1 = new MyRequestTabFragment();
                return tab1;
            case 1:
                CashBuddiesTabFragment tab2 = new CashBuddiesTabFragment();
                return tab2;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
