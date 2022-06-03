package com.example.myapplication.tabbedactivity;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.myapplication.EnterActivity;
import com.example.myapplication.R;
import com.example.myapplication.tabbedactivity.fragments.NewsFragment;
import com.example.myapplication.tabbedactivity.fragments.ProfileFragment;
import com.example.myapplication.tabbedactivity.fragments.TasksFragment;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_2, R.string.tab_text_3};
    private final Context mContext;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0:
                return NewsFragment.newInstance(EnterActivity.enterist);
            case 1:
                return TasksFragment.newInstance(EnterActivity.enterist);
            case 2:
                return ProfileFragment.newInstance(EnterActivity.enterist);
            default:
                return null;//Это для того, что бы что-то вернулось, если порядковый номер вдруг будет больше 2. И в данном случае приложение закроется с ошибкой.
        }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        // Show 2 total pages.
        return 3;
    }
}