package com.example.myapplication10;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class PersonFragment extends Fragment {
    //2.TabLayout
    private MyFragMentPagerAdapter myFragMentPagerAdapter;
    private ViewPager vpContainer;
    private TabLayout tabs;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_person, container, false);
        //2.TabLayout
        //TabLayout은 메뉴.xml이 없음.
        vpContainer = view.findViewById(R.id.vp_container);
        tabs = view.findViewById(R.id.tabs);

        myFragMentPagerAdapter = new MyFragMentPagerAdapter(getFragmentManager(),1);

        myFragMentPagerAdapter.addFragment(new Tabs1());
        myFragMentPagerAdapter.addFragment(new Tabs2());


        vpContainer.setAdapter(myFragMentPagerAdapter);

        //tab이랑 연결되어야 함.
        tabs.setupWithViewPager(vpContainer);

        //tab에 아이템 그리기
        tabs.getTabAt(0).setIcon(R.drawable.ic_view);
        tabs.getTabAt(1).setIcon(R.drawable.ic_person_calendar);

        return  view;
    }
}
