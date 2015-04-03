package com.imooc.androiduipatterns.customview.progress;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.imooc.androiduipatterns.R;

public class CustomProgressActivity extends Activity {

    private HorizontalNumberProgressBar mHorizontalNumberProgressBar;

    private Handler mHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            int progress = mHorizontalNumberProgressBar.getProgress();
            mHorizontalNumberProgressBar.setProgress(++progress);
            if (progress >= 100) {
                mHandler.removeMessages(0);
            }
            mHandler.sendEmptyMessageDelayed(0, 100);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_system_progress);
        mHorizontalNumberProgressBar = (HorizontalNumberProgressBar) findViewById(R.id.pb_number_progress);
        mHandler.sendEmptyMessage(0);
    }
}
