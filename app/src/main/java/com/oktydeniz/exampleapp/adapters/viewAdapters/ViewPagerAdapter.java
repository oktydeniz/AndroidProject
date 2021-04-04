package com.oktydeniz.exampleapp.adapters.viewAdapters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.oktydeniz.exampleapp.views.homeScreen.EducationFragment;
import com.oktydeniz.exampleapp.views.homeScreen.GameFragment;

import java.util.List;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    private final List<Fragment> fragmentList = List.of(new EducationFragment(), new GameFragment());
    private final List<String> fragmentTitle = List.of("Eğitim", "Oyun");

    public ViewPagerAdapter(@NonNull FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentTitle.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return fragmentTitle.get(position);
    }

}
