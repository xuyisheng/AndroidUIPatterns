package com.imooc.androiduipatterns.listview.scrollscalelist;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.imooc.androiduipatterns.R;

public class ScrollScaleListViewActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_scroll_scale_list);
        ListView listView = (ListView) findViewById(R.id.lv_scroll_scale_list);
        String[] strings = new String[50];
        for (int i = 0; i < 50; i++) {
            strings[i] = "Test" + i;
        }
        listView.setAdapter(new ScrollScaleAdapter(
                strings,
                this,
                listView));
    }
}
