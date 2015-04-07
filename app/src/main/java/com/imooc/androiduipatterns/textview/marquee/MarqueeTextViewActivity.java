package com.imooc.androiduipatterns.textview.marquee;

import android.app.Activity;
import android.os.Bundle;

import com.imooc.androiduipatterns.R;

public class MarqueeTextViewActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.textview_marquee);
    }
    /* 存在丢失焦点时可以通过强制焦点的方式进行修改
    @Override
    public boolean isFocused() {
        return true;
    }
     */
}
