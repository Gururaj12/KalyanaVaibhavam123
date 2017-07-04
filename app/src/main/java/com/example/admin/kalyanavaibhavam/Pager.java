package com.example.admin.kalyanavaibhavam;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class Pager extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public Pager(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                SearchFrag tab1 = new SearchFrag();
                return tab1;
            case 1:
                Shortlists_frag tab2 = new Shortlists_frag();
                return tab2;
            case 2:
                Contact_frag tab3 = new Contact_frag();
                return tab3;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}