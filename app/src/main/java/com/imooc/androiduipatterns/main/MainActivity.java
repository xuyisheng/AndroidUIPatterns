package com.imooc.androiduipatterns.main;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.Gravity;
import android.view.MenuItem;

import com.imooc.androiduipatterns.R;
import com.imooc.androiduipatterns.custom.CustomMainPage;


public class MainActivity extends Activity
        implements MainPageMenu.onMainPageMenuItemClick {

    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_page);
        initView();
        initFragment();
    }

    private void initView() {
        getActionBar().setDisplayHomeAsUpEnabled(true);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.dl_main_page);
        ActionBarDrawerToggle mDrawerToggle =
                new ActionBarDrawerToggle(this, mDrawerLayout,
                        R.string.abc_action_bar_home_description,
                        R.string.abc_action_bar_home_description_format);
        mDrawerToggle.syncState();
        mDrawerLayout.setDrawerListener(mDrawerToggle);
    }

    private void initFragment() {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        MainPageContent fragmentContent = new MainPageContent();
        MainPageMenu fragmentMenu = new MainPageMenu();
        fragmentTransaction.replace(R.id.fl_main_page_content, fragmentContent);
        fragmentTransaction.replace(R.id.fl_main_page_menu, fragmentMenu);
        fragmentTransaction.commit();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                if (mDrawerLayout.isDrawerOpen(Gravity.START)) {
                    mDrawerLayout.closeDrawers();
                } else {
                    mDrawerLayout.openDrawer(Gravity.START);
                }
        }
        return true;
    }

    @Override
    public void onItemClick(int position) {
        mDrawerLayout.closeDrawers();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment fragment;
        switch (position) {
            case 1:
                fragment = new CustomMainPage();
                break;
            default:
                fragment = new MainPageContent();
                break;
        }
        fragmentTransaction.replace(R.id.fl_main_page_content, fragment);
        fragmentTransaction.commit();
    }
}
