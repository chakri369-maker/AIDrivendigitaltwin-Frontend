package com.simats.ai_drivendigitaltwin.model;

public class MarketActivity {
    private String source;
    private String type;
    private String description;
    private String timestamp;
    private String dotColor; // hex color for the dot

    public MarketActivity(String source, String type, String description, String timestamp, String dotColor) {
        this.source = source;
        this.type = type;
        this.description = description;
        this.timestamp = timestamp;
        this.dotColor = dotColor;
    }

    public String getSource() {
        return source;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getDotColor() {
        return dotColor;
    }
}
