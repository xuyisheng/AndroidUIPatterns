package com.imooc.androiduipatterns.main;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.imooc.androiduipatterns.R;

import java.util.List;

public class MainPageMenuRecyclerAdapter
        extends RecyclerView.Adapter<MainPageMenuRecyclerAdapter.ViewHolder> {

    public OnItemClickListener itemClickListener;
    private List<String> mData;

    public MainPageMenuRecyclerAdapter(List<String> data) {
        mData = data;
    }

    public void setOnItemClickListener(
            OnItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(
                R.layout.main_page_menu_item, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.button.setText(mData.get(i));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {

        public Button button;

        public ViewHolder(View itemView) {
            super(itemView);
            button = (Button) itemView;
            button.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (itemClickListener != null) {
                itemClickListener.onItemClick(v, getPosition());
            }
        }
    }
}
