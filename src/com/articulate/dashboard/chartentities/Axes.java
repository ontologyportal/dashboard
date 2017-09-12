package com.articulate.dashboard.chartentities;

/**
 * This code is copyright Infosys Ltd 2017.
 * @author mohit.gupta
 *
 */
public class Axes {
	Tick ticks = new Tick();
	ScaleLabel scaleLabel = new ScaleLabel();

	public Tick getTicks() {
		return ticks;
	}

	public void setTicks(Tick ticks) {
		this.ticks = ticks;
	}

	public ScaleLabel getScaleLabel() {
		return scaleLabel;
	}

	public void setScaleLabel(ScaleLabel scaleLabel) {
		this.scaleLabel = scaleLabel;
	}

}