package com.sergej.balabanov.practice1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {


    private final List<Conversion> mConversions;
    private final OnItemClickListener mListener;

    public MainAdapter(List<Conversion> conversions, OnItemClickListener listener) {
        mConversions = new ArrayList<>(conversions);
        mListener = listener;
    }

    @NonNull
    @Override
    public MainAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        final View view = layoutInflater.inflate(R.layout.unit_adapter_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainAdapter.ViewHolder holder, int position) {
        holder.bindView(mConversions.get(position), mListener);
    }

    @Override
    public int getItemCount() {
        return mConversions.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mTextView;


        public ViewHolder(View itemView) {
            super(itemView);
            mTextView = itemView.findViewById(R.id.text_view);
        }

        public void bindView(final Conversion conversion, final OnItemClickListener listener) {
            mTextView.setText(conversion.mLabelRes);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(conversion);
                }
            });

        }
    }
}

