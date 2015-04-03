package com.imooc.androiduipatterns.listview;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.imooc.androiduipatterns.R;
import com.imooc.androiduipatterns.listview.emptylist.EmptyOrLoadListViewActivity;
import com.imooc.androiduipatterns.listview.pullzoomlist.PullZoomListViewActivity;
import com.imooc.androiduipatterns.listview.scrollscalelist.ScrollScaleListViewActivity;

public class ListViewMainPage extends Fragment implements View.OnClickListener {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.listview_main_page, container, false);
        view.findViewById(R.id.btn_listview_main_empty).setOnClickListener(this);
        view.findViewById(R.id.btn_listview_scroll_scale).setOnClickListener(this);
        view.findViewById(R.id.btn_listview_pull_zoom).setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_listview_main_empty:
                startActivity(new Intent(getActivity(), EmptyOrLoadListViewActivity.class));
                break;
            case R.id.btn_listview_scroll_scale:
                startActivity(new Intent(getActivity(), ScrollScaleListViewActivity.class));
                break;
            case R.id.btn_listview_pull_zoom:
                startActivity(new Intent(getActivity(), PullZoomListViewActivity.class));
                break;
        }
    }
}
