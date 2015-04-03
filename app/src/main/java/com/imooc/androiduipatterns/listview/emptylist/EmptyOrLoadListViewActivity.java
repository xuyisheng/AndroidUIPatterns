package com.imooc.androiduipatterns.listview.emptylist;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class EmptyOrLoadListViewActivity extends Activity {

    private ListView mListView;
    private int i = 0;
    private EmptyOrLoadListView mView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mView = new EmptyOrLoadListView(this);
        setContentView(mView);
        mView.setEmptyView(true);
        mListView = mView.getListView();

        test();
    }

    private void test() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (i % 2 == 0) {
                    mView.setLoadingProgressBar(false);
                    mView.setEmptyView(false);
                    mListView.setAdapter(new ArrayAdapter<>(
                            EmptyOrLoadListViewActivity.this,
                            android.R.layout.simple_list_item_1,
                            new String[]{"Empty", "Loading", "ListView"}));
                } else {
                    mView.setLoadingProgressBar(true);
                    mListView.setAdapter(null);
                }
                i++;
                test();
            }
        }, 3000);
    }
}
