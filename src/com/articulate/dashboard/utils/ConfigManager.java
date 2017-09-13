package com.articulate.dashboard.utils;

/**
 * This code is copyright Infosys Ltd 2017.
 * This software is released under the GNU Public License.You can redistribute it and/or modify
 * it under the terms of the GNU General Public License.
 * 
 * @author mohit.gupta
 */

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import com.articulate.dashboard.chartentities.Corpus;

import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class ConfigManager {

    public static void initialize() throws IOException {

        try {
            String dashboardHome = System.getenv("DASHBOARD_HOME");
            String configFilePath = dashboardHome + File.separator + "config.xml";
            String recordsFilePath = dashboardHome + File.separator + "records.csv";
            File inputFile = new File(configFilePath);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            NodeList corpusDataListNode = doc.getElementsByTagName("corpusData");
            RecordsManager.recordFile = new File(recordsFilePath);
            Node corpusDataNode = corpusDataListNode.item(0);
            Element corpusDataElement = (Element) corpusDataNode;
            NodeList corporas = corpusDataElement.getElementsByTagName("corpus");
            Corpus corpus;
            for (int temp = 0; temp < corporas.getLength(); temp++) {
                Node corpusNode = corporas.item(temp);
                Element corpusElement = (Element) corpusNode;
                corpus = new Corpus();
                corpus.setName(corpusElement.getElementsByTagName("name").item(0).getTextContent());
                corpus.setColor(corpusElement.getElementsByTagName("color").item(0).getTextContent());
                corpus.setLabel(corpusElement.getElementsByTagName("label").item(0).getTextContent());
                RecordsManager.corpusMapping.put(corpus.getName(), corpus);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws IOException {

        System.out.println(System.getenv("DASHBOARD_HOME"));
        initialize();
    }

}
