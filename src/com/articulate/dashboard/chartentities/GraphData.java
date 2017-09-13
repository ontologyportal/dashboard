package com.articulate.dashboard.chartentities;

/**
 * This code is copyright Infosys Ltd 2017.
 *
 * @author mohit.gupta
 */

import java.util.List;

public class GraphData {
    transient String metric;
    transient String xAxisLabel = "time";
    List<String> labels;
    List<Dataset> datasets;

    public String getMetric() {

        return metric;
    }

    public void setMetric(String metric) {

        this.metric = metric;
    }

    public String getxAxisLabel() {

        return xAxisLabel;
    }

    public void setxAxisLabel(String xAxisLabel) {

        this.xAxisLabel = xAxisLabel;
    }

    public List<String> getLabels() {

        return labels;
    }

    public void setLabels(List<String> labels) {

        this.labels = labels;
    }

    public List<Dataset> getDatasets() {

        return datasets;
    }

    public void setDatasets(List<Dataset> datasets) {

        this.datasets = datasets;
    }

}