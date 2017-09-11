package com.articulate.dashboard.chartentities;

/**
 * This code is copyright Infosys Ltd 2017.
 * @author mohit.gupta
 *
 */

import java.util.ArrayList;
import java.util.List;

public class Scale {
	List<Axes> xAxes = new ArrayList<>();
	List<Axes> yAxes = new ArrayList<>();

	public List<Axes> getxAxes() {
		return xAxes;
	}

	public void setxAxes(List<Axes> xAxes) {
		this.xAxes = xAxes;
	}

	public List<Axes> getyAxes() {
		return yAxes;
	}

	public void setyAxes(List<Axes> yAxes) {
		this.yAxes = yAxes;
	}

}
