package com.imooc.androiduipatterns.popup;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.imooc.androiduipatterns.R;
import com.imooc.androiduipatterns.popup.popuplist.PopupListActivity;
import com.imooc.androiduipatterns.popup.dragpopup.DragPopupActivity;

public class PopupMainPage extends Fragment implements View.OnClickListener {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.popup_main_page, container, false);
        view.findViewById(R.id.btn_popup_main_dragpopup).setOnClickListener(this);
        view.findViewById(R.id.btn_popup_main_popuplist).setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_popup_main_dragpopup:
                startActivity(new Intent(getActivity(), DragPopupActivity.class));
                break;
            case R.id.btn_popup_main_popuplist:
                startActivity(new Intent(getActivity(), PopupListActivity.class));
                break;
        }
    }
}
