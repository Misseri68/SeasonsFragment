package com.example.fragments;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPagerAdapter extends FragmentStateAdapter {

    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        // Define el nombre de la estación basado en la posición
        String season;
        switch (position) {
            case 0:
                season = "Fall";
                break;
            case 1:
                season = "Winter";
                break;
            case 2:
                season = "Spring";
                break;
            case 3:
            default:
                season = "Summer";
                break;
        }
        return SeasonFragment.newInstance(season);
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
