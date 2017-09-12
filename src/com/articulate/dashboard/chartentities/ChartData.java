package com.articulate.dashboard.chartentities;

/**
 * This code is copyright Infosys Ltd 2017.
 * @author mohit.gupta
 *
 */
public class ChartData {
	transient String name;
	String type = "line";
	GraphData data;
	Option options;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public GraphData getData() {
		return data;
	}

	public void setData(GraphData data) {
		this.data = data;
	}

	public Option getOptions() {
		return options;
	}

	public void setOptions(Option options) {
		this.options = options;
	}

}
