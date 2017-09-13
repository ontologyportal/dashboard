package com.articulate.dashboard.utils;

/**
 * This code is copyright Infosys Ltd 2017.
 * This software is released under the GNU Public License.You can redistribute it and/or modify
 * it under the terms of the GNU General Public License.
 * 
 * @author mohit.gupta
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.articulate.dashboard.chartentities.*;
import com.google.gson.Gson;

public class RecordsManager {

    static File recordFile = null;
    static File colorFile = null;
    static int currentColor = 0;
    // map that stores sorted list of records with respect of each metric
    static Map<String, List<Record>> metricRecords = null;
    static Map<String, Corpus> corpusMapping = new HashMap<>();
    static List<String> chartJsons = null;
    static List<String> chartNames = null;

    public synchronized static void resetRecords() {

        metricRecords = null;
    }

    public synchronized static void readRecords() throws IOException {

        if (metricRecords != null) {
            return;
        }
        metricRecords = new HashMap<>();
        BufferedReader reader = new BufferedReader(new FileReader(RecordsManager.recordFile));
        String line;
        Record record;
        String[] fields;
        while ((line = reader.readLine()) != null) {
            record = new Record();
            fields = line.split(",");
            record.setTimestamp(fields[0]);
            record.setCorpora(fields[1]);
            record.setMetric(fields[2]);
            record.setMetric_value(fields[3]);
            if (!metricRecords.containsKey(record.getMetric())) {
                metricRecords.put(record.getMetric(), new ArrayList<>());
            }
            metricRecords.get(record.getMetric()).add(record);
        }

        reader.close();
    }

    private static GraphData getGraphData(String metric) {

        GraphData graphData = new GraphData();
        List<Record> recordsForMetric = metricRecords.get(metric);
        graphData.setMetric(metric);
        List<String> labels = new ArrayList<>();
        if (recordsForMetric == null) {
            return graphData;
        }

        Map<String, Integer> labelOrderMapping = new HashMap<>();
        for (Record record : recordsForMetric) {
            if (labels.isEmpty() || !labels.get(labels.size() - 1).equalsIgnoreCase(record.getTimestamp())) {
                labels.add(record.getTimestamp());
                labelOrderMapping.put(record.getTimestamp(), labels.size() - 1);
            }
        }

        Map<String, Dataset> datasets = new HashMap<>();
        for (Record record : recordsForMetric) {
            if (corpusMapping.get(record.getCorpora()) == null) {
                continue;
            }
            if (!datasets.containsKey(record.getCorpora())) {
                datasets.put(record.getCorpora(), new Dataset());
                datasets.get(record.getCorpora()).setBorderColor(corpusMapping.get(record.getCorpora()).getColor());
                datasets.get(record.getCorpora()).setLabel(corpusMapping.get(record.getCorpora()).getLabel());
                datasets.get(record.getCorpora()).setData(new String[labels.size()]);
            }
            datasets.get(record.getCorpora()).getData()[labelOrderMapping.get(record.getTimestamp())] = record
                    .getMetric_value();
        }

        graphData.setDatasets(new ArrayList<>(datasets.values()));
        graphData.setLabels(labels);
        return graphData;
    }

    private static List<ChartData> getAllChartData() {

        List<ChartData> charts = new ArrayList<>();
        ChartData chartData;
        GraphData data;
        for (Map.Entry<String, List<Record>> entry : metricRecords.entrySet()) {
            chartData = new ChartData();
            data = getGraphData(entry.getKey());
            chartData.setData(data);
            Option options = new Option();
            Axes xAxes = new Axes();
            Axes yAxes = new Axes();
            xAxes.getScaleLabel().setLabelString(data.getxAxisLabel());
            yAxes.getScaleLabel().setLabelString(data.getMetric());
            options.getScales().getxAxes().add(xAxes);
            options.getScales().getyAxes().add(yAxes);
            chartData.setOptions(options);
            chartData.setName(data.getMetric());
            charts.add(chartData);
        }

        return charts;
    }

    public static List<String> getChartJsons() {

        if (chartJsons != null) {
            return chartJsons;
        }
        chartJsons = new ArrayList<>();
        List<ChartData> charts = getAllChartData();
        Gson gson = new Gson();
        for (ChartData chart : charts) {
            chartJsons.add(gson.toJson(chart));
        }
        return chartJsons;
    }

    public static List<String> getAllChartNames() {

        if (chartNames != null) {
            return chartNames;
        }
        chartNames = new ArrayList<>();
        List<ChartData> charts = getAllChartData();
        for (ChartData chart : charts) {
            chartNames.add(chart.getName().substring(0, 1).toUpperCase() + chart.getName().substring(1));
        }
        return chartNames;
    }

}
