package com.imooc.androiduipatterns.customview.progress;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ProgressBar;

import com.imooc.androiduipatterns.R;

public class SystemProgressStyleActivity extends Activity {

    private ProgressBar mProgressBar;

    private Handler mHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            int progress = mProgressBar.getProgress();
            mProgressBar.setProgress(++progress);
            mProgressBar.setSecondaryProgress(++progress + 10);
            if (progress >= 100) {
                mHandler.removeMessages(0);
            }
            mHandler.sendEmptyMessageDelayed(0, 100);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_system_systemstyle_progress);
        mProgressBar = (ProgressBar) findViewById(R.id.pb_systemstyle_progressbar);
        mHandler.sendEmptyMessage(0);
    }
}
