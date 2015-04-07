package com.imooc.androiduipatterns.textview;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.imooc.androiduipatterns.R;
import com.imooc.androiduipatterns.textview.marquee.MarqueeTextViewActivity;

public class TextViewMainPage extends Fragment implements View.OnClickListener {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.textview_main_page, container, false);
        view.findViewById(R.id.btn_textview_Marquee).setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_textview_Marquee:
                startActivity(new Intent(getActivity(), MarqueeTextViewActivity.class));
                break;
        }
    }
}
