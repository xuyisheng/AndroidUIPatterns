package com.imooc.androiduipatterns.main;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.imooc.androiduipatterns.R;

import java.util.ArrayList;
import java.util.List;

public class MainPageMenu extends Fragment {

    private onMainPageMenuItemClick mCallback;
    private List<String> mData = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_page_menu, container, false);
        initMenuData();
        initMenu(mData, view);
        return view;
    }

    private void initMenu(List<String> data, View view) {
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_main_page_menu);
        MainPageMenuRecyclerAdapter adapter = new MainPageMenuRecyclerAdapter(data);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(
                new MainPageMenuRecyclerAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(final View view, int position) {
                        final int pos = position;
                        ObjectAnimator animator = ObjectAnimator.ofFloat(
                                view,
                                "translationZ",
                                0, 15, 0
                        );
                        animator.addListener(new AnimatorListenerAdapter() {
                            @Override
                            public void onAnimationEnd(Animator animation) {
                                mCallback.onItemClick(pos);
                            }
                        });
                        animator.start();
                    }
                });
    }

    private void initMenuData() {
        mData.add("UI Patterns");
        mData.add("Custom View");
        mData.add("Popups");
        mData.add("ListView");
        mData.add("TextView");
        mData.add("Blur");
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mCallback = (onMainPageMenuItemClick) activity;
    }

    public interface onMainPageMenuItemClick {
        public void onItemClick(int position);
    }
}
