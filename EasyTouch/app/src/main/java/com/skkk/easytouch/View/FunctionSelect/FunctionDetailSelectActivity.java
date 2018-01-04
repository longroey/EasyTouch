package com.skkk.easytouch.View.FunctionSelect;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.skkk.easytouch.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class FunctionDetailSelectActivity extends AppCompatActivity {

    private static final String TAG = "ShapeSettingActivity";
    @Bind(R.id.tb_function_detail_select)
    Toolbar tbFunctionDetailSelect;
    @Bind(R.id.tl_function_detail_select)
    TabLayout tlFunctionDetailSelect;
    @Bind(R.id.vp_function_detail_select)
    ViewPager vpFunctionDetailSelect;

    private ArrayList<Fragment> fragmentList;
    private String[] TITLE = new String[]{"基础操作", "应用","快捷方式"};
    private ViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_function_detail_select);
        ButterKnife.bind(this);

        initUI();
    }

    /**
     * 初始化UI
     */
    private void initUI() {
        tbFunctionDetailSelect.setTitle("功能选择");
        tbFunctionDetailSelect.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        tbFunctionDetailSelect.setNavigationIcon(R.drawable.ic_arrow_back_white);

        fragmentList = new ArrayList<Fragment>();
        fragmentList.add(FunctionDetailBaseFragment.newInstance("", ""));
        fragmentList.add(FunctionDetailAppFragment.newInstance("", ""));
        fragmentList.add(FunctionDetailShortCutFragment.newInstance("", ""));

        adapter = new ViewPagerAdapter(getSupportFragmentManager(), fragmentList, TITLE);
        vpFunctionDetailSelect.setAdapter(adapter);

        //实例化TabPageIndicator然后设置ViewPager与之关联
        tlFunctionDetailSelect.setupWithViewPager(vpFunctionDetailSelect);

        //如果我们要对ViewPager设置监听，用indicator设置就行了
        tlFunctionDetailSelect.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                vpFunctionDetailSelect.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }


    public class ViewPagerAdapter extends FragmentStatePagerAdapter {
        private List<Fragment> fragments;
        private String[] TITLE;

        public ViewPagerAdapter(FragmentManager fm, List<Fragment> fragments, String[] TITLE) {
            super(fm);
            this.fragments = fragments;
            this.TITLE = TITLE;
        }


        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return TITLE.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return TITLE[position];
        }

    }

}
