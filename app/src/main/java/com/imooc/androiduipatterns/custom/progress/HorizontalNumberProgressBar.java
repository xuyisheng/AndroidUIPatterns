package com.imooc.androiduipatterns.custom.progress;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.ProgressBar;

public class HorizontalNumberProgressBar extends ProgressBar {

    private Paint mPaint;
    private int mProgressWidth;
    private int mProgressHeight;

    public HorizontalNumberProgressBar(Context context) {
        this(context, null);
    }

    public HorizontalNumberProgressBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public HorizontalNumberProgressBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        setHorizontalScrollBarEnabled(true);
        mPaint = new Paint();
        mPaint.setStrokeWidth(5);
        mPaint.setTextSize(30);
        mPaint.setColor(getResources().getColor(android.R.color.holo_blue_bright));
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mProgressWidth = w - getPaddingLeft() - getPaddingRight();
        mProgressHeight = h - getPaddingTop() - getPaddingBottom();
    }

    @Override
    protected synchronized void onDraw(Canvas canvas) {
        canvas.translate(0, mProgressHeight / 2);
        float radio = getProgress() * 1.0f / getMax();
        float currentX = (int) (mProgressWidth * radio);
        String text = getProgress() + "%";
        float textWidth = mPaint.measureText(text);
        Paint.FontMetrics metrics = mPaint.getFontMetrics();
        float textHeight = (float) Math.ceil(metrics.descent - metrics.ascent);
        canvas.drawText(text, currentX - textWidth, -textHeight, mPaint);
        canvas.drawLine(0, 0, currentX, 0, mPaint);
        canvas.drawCircle(currentX, 0, 10, mPaint);
    }
}
