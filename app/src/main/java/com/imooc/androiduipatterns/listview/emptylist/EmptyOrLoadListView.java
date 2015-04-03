package com.imooc.androiduipatterns.listview.emptylist;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.imooc.androiduipatterns.R;

public class EmptyOrLoadListView extends FrameLayout {

    private ListView mListView;
    private ProgressBar mProgressBar;
    private ImageView mImageView;
    private Context mContext;

    public EmptyOrLoadListView(Context context) {
        super(context);
        initView();
    }

    public EmptyOrLoadListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public EmptyOrLoadListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        mContext = getContext();
        mListView = new ListView(mContext);
        LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT,
                LayoutParams.MATCH_PARENT);
        mListView.setLayoutParams(params);
        addView(mListView);
    }

    public ListView getListView() {
        return mListView;
    }

    public void setEmptyView(boolean flag) {
        if (flag) {
            mImageView = new ImageView(mContext);
            LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT,
                    LayoutParams.WRAP_CONTENT);
            params.gravity = Gravity.CENTER;
            mImageView.setLayoutParams(params);
            mImageView.setImageResource(R.mipmap.ic_launcher);
            addView(mImageView);
        } else {
            removeView(mImageView);
        }
    }

    public void setLoadingProgressBar(boolean flag) {
        if (flag) {
            mProgressBar = new ProgressBar(mContext);
            LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT,
                    LayoutParams.WRAP_CONTENT);
            params.gravity = Gravity.CENTER;
            mProgressBar.setLayoutParams(params);
            addView(mProgressBar);
        } else {
            removeView(mProgressBar);
        }
    }
}
