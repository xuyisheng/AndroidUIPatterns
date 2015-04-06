package com.imooc.androiduipatterns.blur.fastblur;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;

import com.imooc.androiduipatterns.R;

public class FastBlurActivity extends Activity implements SeekBar.OnSeekBarChangeListener {

    private SeekBar mScaleFactorSeekBar;
    private SeekBar mRadiusSeekBar;
    private ImageView mImageView;
    private float scaleFactor = 1, radius = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.blur_fast_blur);
        mImageView = (ImageView) findViewById(R.id.iv_blur_fast_blur);
        mImageView.post(new Runnable() {
            @Override
            public void run() {
                blur(R.drawable.blurtest, mImageView, 1, 1);
            }
        });
        mScaleFactorSeekBar = (SeekBar) findViewById(R.id.sb_scalefactor_blur_fast_blur);
        mRadiusSeekBar = (SeekBar) findViewById(R.id.sb_radius_blur_fast_blur);
        mScaleFactorSeekBar.setOnSeekBarChangeListener(this);
        mRadiusSeekBar.setOnSeekBarChangeListener(this);
        mScaleFactorSeekBar.setMax(10);
        mRadiusSeekBar.setMax(50);
    }

    private void blur(int resID, ImageView view, float scaleFactor, float radius) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = (int) scaleFactor;
        Bitmap sample = BitmapFactory.decodeResource(getResources(),
                resID, options);
        Bitmap bm = Bitmap.createBitmap(
                sample.getWidth(),
                sample.getHeight(),
                Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bm);
        canvas.drawBitmap(sample, 0, 0, null);
        view.setImageBitmap(FastBlurUtil.doBlur(bm, (int) radius, true));
    }

    /* another way to blur
    private void blur(Bitmap bkg, View view) {
        long startMs = System.currentTimeMillis();
        float scaleFactor = 8;
        float radius = 2;

        Bitmap overlay = Bitmap.createBitmap(
                (int) (view.getMeasuredWidth() / scaleFactor),
                (int) (view.getMeasuredHeight() / scaleFactor),
                Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(overlay);
        canvas.translate(-view.getLeft() / scaleFactor, -view.getTop()
                / scaleFactor);
        canvas.scale(1 / scaleFactor, 1 / scaleFactor);
        Paint paint = new Paint();
        paint.setFlags(Paint.FILTER_BITMAP_FLAG);
        canvas.drawBitmap(bkg, 0, 0, paint);

        overlay = FastBlur.doBlur(overlay, (int) radius, true);
        view.setBackground(new BitmapDrawable(getResources(), overlay));
        System.out.println(System.currentTimeMillis() - startMs + "ms");
    }
    */

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        if (seekBar.getId() == R.id.sb_scalefactor_blur_fast_blur) {
            scaleFactor = progress;
        } else if (seekBar.getId() == R.id.sb_radius_blur_fast_blur) {
            radius = progress;
        }
        blur(R.drawable.blurtest, mImageView,
                scaleFactor == 0 ? 1 : scaleFactor,
                radius == 0 ? 1 : radius);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
    }
}
