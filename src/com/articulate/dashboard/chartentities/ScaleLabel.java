package com.articulate.dashboard.chartentities;

/**
 * This code is copyright Infosys Ltd 2017.
 * This software is released under the GNU Public License.You can redistribute it and/or modify
 * it under the terms of the GNU General Public License.
 * 
 * @author mohit.gupta
 */
public class ScaleLabel {
    boolean display = true;
    String labelString;

    public boolean isDisplay() {

        return display;
    }

    public void setDisplay(boolean display) {

        this.display = display;
    }

    public String getLabelString() {

        return labelString;
    }

    public void setLabelString(String labelString) {

        this.labelString = labelString;
    }

}
