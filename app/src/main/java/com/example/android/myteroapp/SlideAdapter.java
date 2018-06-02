package com.example.android.myteroapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;
import java.util.Random;

/**
 * Created by abdalla on 12/18/17.
 */

public class SlideAdapter extends RecyclerView.Adapter<SlideViewHolder> {

    private List<SlideData> mSlideData;
    private Context mContext;

    public SlideAdapter(Context mContext, List<SlideData> mSlideData) {
        this.mSlideData = mSlideData;
        this.mContext = mContext;
    }

    @Override
    public SlideViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_slide_item,
                parent, false);
        return new SlideViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final SlideViewHolder holder, int position) {
        holder.mEmailTitle.setText(mSlideData.get(position).getmTitle());
        Random mRandom = new Random();
        final int color = Color.argb(255, mRandom.nextInt(256), mRandom.nextInt(256), mRandom.nextInt(256));
        ((GradientDrawable) holder.mIcon.getBackground()).setColor(color);

        holder.mLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(mContext, DetailActivity.class);
                mIntent.putExtra("title", holder.mEmailTitle.getText().toString());
                mIntent.putExtra("icon", holder.mIcon.getText().toString());
                mIntent.putExtra("colorIcon", color);
                mContext.startActivity(mIntent);
            }
        });
        holder.mIcon.setText(mSlideData.get(position).getmTitle().substring(0, 1));


    }

    @Override
    public int getItemCount() {
        return mSlideData.size();
    }
}

class SlideViewHolder extends RecyclerView.ViewHolder {

    TextView mIcon;
    TextView mEmailTitle;
    RelativeLayout mLayout;

    SlideViewHolder(View itemView) {
        super(itemView);

        mIcon = itemView.findViewById(R.id.tvIcon);
        mEmailTitle = itemView.findViewById(R.id.tvEmailTitle);
        mLayout = itemView.findViewById(R.id.layout);
    }
}
