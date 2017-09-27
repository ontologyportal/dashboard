package com.articulate.dashboard.chartentities;

/**
 * This code is copyright Infosys Ltd 2017.
 * This software is released under the GNU Public License.You can redistribute it and/or modify
 * it under the terms of the GNU General Public License.
 * 
 * @author mohit.gupta
 */
public class Dataset {

    String label;
    String[] data;
    String borderColor;
    int borderWidth = 1;
    boolean fill = false;

    public String getLabel() {

        return label;
    }

    public void setLabel(String label) {

        this.label = label;
    }

    public String[] getData() {

        return data;
    }

    public void setData(String[] data) {

        this.data = data;
    }

    public String getBorderColor() {

        return borderColor;
    }

    public void setBorderColor(String borderColor) {

        this.borderColor = borderColor;
    }

    public int getBorderWidth() {

        return borderWidth;
    }

    public void setBorderWidth(int borderWidth) {

        this.borderWidth = borderWidth;
    }

    public boolean isFill() {

        return fill;
    }

    public void setFill(boolean fill) {

        this.fill = fill;
    }

}