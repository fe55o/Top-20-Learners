package com.example.top20;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class myPagerAdapter extends FragmentPagerAdapter {
    private int numoftabs;
    private final List<Fragment>  mfragment = new ArrayList<>();
    public myPagerAdapter(FragmentManager fm) {
        super(fm);

    }

    @Override
    public Fragment getItem(int position) {

        return mfragment.get(position);
    }

    @Override
    public int getCount() {
        return mfragment.size();
    }



public void addFragment(Fragment fragment){
    mfragment.add(fragment);

}
}
