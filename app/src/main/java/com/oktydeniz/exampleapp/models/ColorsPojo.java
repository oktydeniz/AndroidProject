package com.oktydeniz.exampleapp.models;

import com.google.gson.annotations.SerializedName;

public class ColorsPojo {

    @SerializedName("id")
    private int id;

    @SerializedName("color_name")
    private String color_name;

    @SerializedName("color_image")
    private String color_image;

    @SerializedName("color_text")
    private String color_text;

    @SerializedName("level_id")
    private String level_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getColor_name() {
        return color_name;
    }

    public void setColor_name(String color_name) {
        this.color_name = color_name;
    }

    public String getColor_image() {
        return color_image;
    }

    public void setColor_image(String color_image) {
        this.color_image = color_image;
    }

    public String getColor_text() {
        return color_text;
    }

    public void setColor_text(String color_text) {
        this.color_text = color_text;
    }

    public String getLevel_id() {
        return level_id;
    }

    public void setLevel_id(String level_id) {
        this.level_id = level_id;
    }
}
