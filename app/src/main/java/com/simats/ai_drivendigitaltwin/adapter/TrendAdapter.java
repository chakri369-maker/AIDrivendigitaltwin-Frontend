package com.simats.ai_drivendigitaltwin.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.simats.ai_drivendigitaltwin.R;
import com.simats.ai_drivendigitaltwin.model.Trend;

import java.util.List;

public class TrendAdapter extends RecyclerView.Adapter<TrendAdapter.TrendViewHolder> {

    private List<Trend> trends;

    public TrendAdapter(List<Trend> trends) {
        this.trends = trends;
    }

    public void updateTrends(List<Trend> newTrends) {
        this.trends = newTrends;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TrendViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_trend, parent, false);
        return new TrendViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TrendViewHolder holder, int position) {
        Trend trend = trends.get(position);
        
        holder.txtTrendName.setText(trend.getName());
        holder.txtTrendIndustry.setText(trend.getIndustry());
        holder.txtPopularityScore.setText(String.valueOf(trend.getPopularityScore()));
        holder.txtChange.setText(trend.getChange());
        
        // Set color based on positive/negative change
        if (trend.isPositive()) {
            holder.txtChange.setTextColor(holder.itemView.getContext().getResources().getColor(android.R.color.holo_green_light));
            holder.imgTrendIcon.setColorFilter(holder.itemView.getContext().getResources().getColor(android.R.color.holo_green_light));
        } else {
            holder.txtChange.setTextColor(holder.itemView.getContext().getResources().getColor(android.R.color.holo_red_light));
            holder.imgTrendIcon.setColorFilter(holder.itemView.getContext().getResources().getColor(android.R.color.holo_red_light));
        }
    }

    @Override
    public int getItemCount() {
        return trends.size();
    }

    static class TrendViewHolder extends RecyclerView.ViewHolder {
        TextView txtTrendName, txtTrendIndustry, txtPopularityScore, txtChange;
        ImageView imgTrendIcon;

        TrendViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTrendName = itemView.findViewById(R.id.txtTrendName);
            txtTrendIndustry = itemView.findViewById(R.id.txtTrendIndustry);
            txtPopularityScore = itemView.findViewById(R.id.txtPopularityScore);
            txtChange = itemView.findViewById(R.id.txtChange);
            imgTrendIcon = itemView.findViewById(R.id.imgTrendIcon);
        }
    }
}
