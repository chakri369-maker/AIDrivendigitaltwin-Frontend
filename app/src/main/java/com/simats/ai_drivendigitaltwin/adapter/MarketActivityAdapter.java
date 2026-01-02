package com.simats.ai_drivendigitaltwin.adapter;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.simats.ai_drivendigitaltwin.R;
import com.simats.ai_drivendigitaltwin.model.MarketActivity;

import java.util.List;

public class MarketActivityAdapter extends RecyclerView.Adapter<MarketActivityAdapter.ActivityViewHolder> {

    private List<MarketActivity> activities;

    public MarketActivityAdapter(List<MarketActivity> activities) {
        this.activities = activities;
    }

    public void updateActivities(List<MarketActivity> newActivities) {
        this.activities = newActivities;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ActivityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_market_activity, parent, false);
        return new ActivityViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ActivityViewHolder holder, int position) {
        MarketActivity activity = activities.get(position);
        
        holder.txtSource.setText(activity.getSource());
        holder.txtType.setText(activity.getType());
        holder.txtDescription.setText(activity.getDescription());
        holder.txtTimestamp.setText(activity.getTimestamp());
        
        // Set dot color
        GradientDrawable dotBackground = (GradientDrawable) holder.dotIndicator.getBackground();
        if (dotBackground != null) {
            dotBackground.setColor(Color.parseColor(activity.getDotColor()));
        } else {
            holder.dotIndicator.setBackgroundColor(Color.parseColor(activity.getDotColor()));
        }
    }

    @Override
    public int getItemCount() {
        return activities.size();
    }

    static class ActivityViewHolder extends RecyclerView.ViewHolder {
        View dotIndicator;
        TextView txtSource, txtType, txtDescription, txtTimestamp;

        ActivityViewHolder(@NonNull View itemView) {
            super(itemView);
            dotIndicator = itemView.findViewById(R.id.dotIndicator);
            txtSource = itemView.findViewById(R.id.txtSource);
            txtType = itemView.findViewById(R.id.txtType);
            txtDescription = itemView.findViewById(R.id.txtDescription);
            txtTimestamp = itemView.findViewById(R.id.txtTimestamp);
        }
    }
}
