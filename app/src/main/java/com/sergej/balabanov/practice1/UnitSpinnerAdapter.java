package com.sergej.balabanov.practice1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class UnitSpinnerAdapter extends BaseAdapter {

    @Override
    public int getCount() {
        return Unit.values().length;
    }

    @Override
    public Unit getItem(int position) {
        return Unit.values()[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        if (view == null) {
            view = LayoutInflater.from(parent.getContext())
                    .inflate(android.R.layout.simple_list_item_1, parent, false);
            view.setTag(new UnitHolder(view));
        }
        UnitHolder holder = (UnitHolder) view.getTag();
        int titleResourceId = getItem(position).getLabelResource();
        holder.mTitle.setText(titleResourceId);
        return view;
    }

    private class UnitHolder {
        private final TextView mTitle;
        private UnitHolder(View v) {
            mTitle = v.findViewById(android.R.id.text1);
        }
    }
}

