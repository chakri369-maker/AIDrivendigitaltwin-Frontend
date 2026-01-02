package com.simats.ai_drivendigitaltwin.adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.simats.ai_drivendigitaltwin.R;
import com.simats.ai_drivendigitaltwin.model.Competitor;

import java.util.List;

public class CompetitorAdapter extends RecyclerView.Adapter<CompetitorAdapter.CompetitorViewHolder> {

    private List<Competitor> competitors;

    // Rank badge colors
    private static final int[] RANK_COLORS = {
            Color.parseColor("#8B5CF6"), // #1 Purple
            Color.parseColor("#10B981"), // #2 Green
            Color.parseColor("#3B82F6"), // #3 Blue
            Color.parseColor("#EC4899"), // #4 Pink
            Color.parseColor("#6366F1")  // #5+ Indigo
    };

    public CompetitorAdapter(List<Competitor> competitors) {
        this.competitors = competitors;
    }

    public void updateCompetitors(List<Competitor> newCompetitors) {
        this.competitors = newCompetitors;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CompetitorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_competitor, parent, false);
        return new CompetitorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CompetitorViewHolder holder, int position) {
        Competitor competitor = competitors.get(position);
        
        // Set rank with color
        holder.txtRank.setText("#" + competitor.getRank());
        int colorIndex = Math.min(competitor.getRank() - 1, RANK_COLORS.length - 1);
        holder.txtRank.getBackground().setTint(RANK_COLORS[colorIndex]);
        
        holder.txtCompetitorName.setText(competitor.getName());
        holder.txtCategory.setText(competitor.getCategory());
        holder.txtMarketScore.setText(String.valueOf(competitor.getMarketScore()));
        holder.txtChange.setText(competitor.getChange());
        
        // Set color based on positive/negative change
        if (competitor.isPositive()) {
            holder.txtChange.setTextColor(Color.parseColor("#10B981"));
            holder.imgTrendIcon.setColorFilter(Color.parseColor("#10B981"));
        } else {
            holder.txtChange.setTextColor(Color.parseColor("#EF4444"));
            holder.imgTrendIcon.setColorFilter(Color.parseColor("#EF4444"));
        }
    }

    @Override
    public int getItemCount() {
        return competitors.size();
    }

    static class CompetitorViewHolder extends RecyclerView.ViewHolder {
        TextView txtRank, txtCompetitorName, txtCategory, txtMarketScore, txtChange;
        ImageView imgTrendIcon;

        CompetitorViewHolder(@NonNull View itemView) {
            super(itemView);
            txtRank = itemView.findViewById(R.id.txtRank);
            txtCompetitorName = itemView.findViewById(R.id.txtCompetitorName);
            txtCategory = itemView.findViewById(R.id.txtCategory);
            txtMarketScore = itemView.findViewById(R.id.txtMarketScore);
            txtChange = itemView.findViewById(R.id.txtChange);
            imgTrendIcon = itemView.findViewById(R.id.imgTrendIcon);
        }
    }
}
