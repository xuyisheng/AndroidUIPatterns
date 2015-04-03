package com.imooc.androiduipatterns.listview.scrollscalelist;

import android.animation.ValueAnimator;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.imooc.androiduipatterns.R;

public class ScrollScaleAdapter extends BaseAdapter implements AbsListView.OnScrollListener{

    private String[] mData;
    private Context context;

    public ScrollScaleAdapter(String[] data, Context context, ListView listView) {
        listView.setOnScrollListener(this);
        this.mData = data;
        this.context = context;
    }

    @Override
    public int getCount() {
        return mData.length;
    }

    @Override
    public Object getItem(int position) {
        return mData[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHold viewHold;
        if (convertView == null) {
            viewHold = new ViewHold();
            convertView = LayoutInflater.from(context).inflate(R.layout.listview_scroll_scale_item, parent, false);
            convertView.setTag(viewHold);
        } else {
            viewHold = (ViewHold) convertView.getTag();
        }
        viewHold.textView = (TextView) convertView.findViewById(R.id.tv_scroll_scale_item);
        viewHold.textView.setText(mData[position]);
        viewHold.textView.setTextSize(25);
        startScaleAnimator(convertView, 1.0f, 0.6f);
        return convertView;
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        if (scrollState == AbsListView.OnScrollListener.SCROLL_STATE_FLING) {
            startScaleAnimator(view.getChildAt(0), 1.0f, 0.6f);
        }
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
    }

    public void startScaleAnimator(final View view, float start, float end) {
        ValueAnimator animator = ValueAnimator.ofFloat(start, end);
        animator.setDuration(500);
        animator.start();
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float value = (float) animation.getAnimatedValue();
                view.setScaleX(value);
                view.setScaleY(0.4f + (0.6f * value));
            }
        });
    }

    public class ViewHold {
        public TextView textView;
    }
}
