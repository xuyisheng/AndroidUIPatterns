package com.imooc.androiduipatterns.custom;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.imooc.androiduipatterns.R;
import com.imooc.androiduipatterns.custom.progress.CustomProgressActivity;

public class CustomMainPage extends Fragment implements View.OnClickListener {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.custom_main_page, container, false);
        view.findViewById(R.id.btn_custom_main_progress).setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_custom_main_progress:
                startActivity(new Intent(getActivity(), CustomProgressActivity.class));
                break;
        }
    }
}
