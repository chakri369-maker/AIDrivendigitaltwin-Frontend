package com.simats.ai_drivendigitaltwin.model;

public class Competitor {
    private int rank;
    private String name;
    private String category;
    private int marketScore;
    private String change;
    private boolean isPositive;

    public Competitor(int rank, String name, String category, int marketScore, String change, boolean isPositive) {
        this.rank = rank;
        this.name = name;
        this.category = category;
        this.marketScore = marketScore;
        this.change = change;
        this.isPositive = isPositive;
    }

    public int getRank() {
        return rank;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public int getMarketScore() {
        return marketScore;
    }

    public String getChange() {
        return change;
    }

    public boolean isPositive() {
        return isPositive;
    }
}
