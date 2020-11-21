package com.example.project_p7;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;

public class ViewPagerAdapter extends FragmentStateAdapter {

    //Attributes
    ArrayList<Fragment> fragments = new ArrayList<Fragment>();

    //Constructors
    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    public ViewPagerAdapter(FragmentManager supportFragmentManager, Lifecycle lifecycle) {
        super(supportFragmentManager, lifecycle);
    }


    //Overrided Methods
    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return fragments.get(position);
    }

    @Override
    public int getItemCount() {
        return fragments.size();
    }

    //Methods
    public void addFragment(Fragment fragment){
        fragments.add(fragment);
    }

    public Fragment getFragment(int position){
        return fragments.get(position);
    }
}
