package com.simats.ai_drivendigitaltwin.model;

public class Trend {
    private String name;
    private String industry;
    private int popularityScore;
    private String change;
    private boolean isPositive;

    public Trend(String name, String industry, int popularityScore, String change, boolean isPositive) {
        this.name = name;
        this.industry = industry;
        this.popularityScore = popularityScore;
        this.change = change;
        this.isPositive = isPositive;
    }

    public String getName() {
        return name;
    }

    public String getIndustry() {
        return industry;
    }

    public int getPopularityScore() {
        return popularityScore;
    }

    public String getChange() {
        return change;
    }

    public boolean isPositive() {
        return isPositive;
    }
}
