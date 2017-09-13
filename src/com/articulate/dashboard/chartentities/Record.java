package com.articulate.dashboard.chartentities;

/**
 * This code is copyright Infosys Ltd 2017.
 *
 * @author mohit.gupta
 */

public class Record {

    private String timestamp;
    private String corpora;
    private String metric;
    private String metric_value;

    public String getTimestamp() {

        return timestamp;
    }

    public void setTimestamp(String timestamp) {

        this.timestamp = timestamp;
    }

    public String getCorpora() {

        return corpora;
    }

    public void setCorpora(String corpora) {

        this.corpora = corpora;
    }

    public String getMetric() {

        return metric;
    }

    public void setMetric(String metric) {

        this.metric = metric;
    }

    public String getMetric_value() {

        return metric_value;
    }

    public void setMetric_value(String metric_value) {

        this.metric_value = metric_value;
    }

}
