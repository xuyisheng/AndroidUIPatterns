package com.imooc.androiduipatterns.popup.dragpopup;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.PopupWindow;

import com.imooc.androiduipatterns.R;

public class DragPopupActivity extends Activity {

    private Button mBtnShowPopup;
    private PopupWindow mPopupWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popup_dragpopup);
        mBtnShowPopup = (Button) findViewById(R.id.btn_popup_ios_style_showpopup);
        mBtnShowPopup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mPopupWindow == null) {
                    createPopup();
                }
            }
        });
    }

    private void createPopup() {
        LayoutInflater layoutInflater = (LayoutInflater) getBaseContext()
                .getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = layoutInflater.inflate(R.layout.popup_dragpopup_popupview, null);
        mPopupWindow = new PopupWindow(popupView, 300, 300);
        Button btnDismiss = (Button) popupView.findViewById(R.id.btn_popup_dragpopup_dismiss);
        btnDismiss.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {
                mPopupWindow.dismiss();
                mPopupWindow = null;
            }
        });
        popupView.setOnTouchListener(new View.OnTouchListener() {
            int startX, startY;
            int offsetX, offsetY;

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        startX = (int) event.getX();
                        startY = (int) event.getY();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        offsetX = (int) event.getRawX() - startX;
                        offsetY = (int) event.getRawY() - startY;
                        mPopupWindow.update(offsetX, offsetY, -1, -1, true);
                        break;
                }
                return true;
            }
        });
        mPopupWindow.showAsDropDown(mBtnShowPopup, 100, 100);
    }
}
