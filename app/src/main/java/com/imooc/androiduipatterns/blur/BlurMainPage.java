package com.imooc.androiduipatterns.blur;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.imooc.androiduipatterns.R;
import com.imooc.androiduipatterns.blur.fastblur.FastBlurActivity;

public class BlurMainPage extends Fragment implements View.OnClickListener {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.blur_main_page, container, false);
        view.findViewById(R.id.btn_blur_fast_blur).setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_blur_fast_blur:
                startActivity(new Intent(getActivity(), FastBlurActivity.class));
                break;
        }
    }
}
