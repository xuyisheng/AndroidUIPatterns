package com.imooc.androiduipatterns.popup.popuplist;

import android.app.Activity;
import android.graphics.drawable.PaintDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.imooc.androiduipatterns.R;
import com.imooc.androiduipatterns.utils.ScreenUtil;

public class PopupListActivity extends Activity {

    private PopupWindow mPopupWindow;
    private ListView mLeftListView;
    private ListView mRightListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popup_popuplist);
        initPopupWindow();
        final TextView textView = (TextView) findViewById(R.id.tv_popup_popuplist_tv1);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPopupWindow.showAsDropDown(textView);
            }
        });
    }

    private void initPopupWindow() {
        View popupView = LayoutInflater.from(this).inflate(R.layout.popup_popuplist_popupview, null);
        mPopupWindow = new PopupWindow(popupView, ScreenUtil.getScreenWidth(this),
                ScreenUtil.getScreenHeight(this));
        mLeftListView = (ListView) popupView.findViewById(R.id.lv_popup_popuplist_left);
        mRightListView = (ListView) popupView.findViewById(R.id.lv_popup_popuplist_right);
        mPopupWindow.setBackgroundDrawable(new PaintDrawable());
        mPopupWindow.setFocusable(true);
        mPopupWindow.setOnDismissListener(null);
        initLeftListView();
        initRightListView();
        mLeftListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // TODO update right
            }
        });
        mRightListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // TODO something
            }
        });
    }

    private void initRightListView() {
        mLeftListView.setSelection(5);
        mLeftListView.setAdapter(new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i"}
        ));
    }

    private void initLeftListView() {
        mRightListView.setAdapter(new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9"}
        ));
    }
}
