package com.articulate.dashboard.utils;

/**
 * This code is copyright Infosys Ltd 2017.
 * This software is released under the GNU Public License.You can redistribute it and/or modify
 * it under the terms of the GNU General Public License.
 * 
 * @author mohit.gupta
 */

import java.util.Timer;
import java.util.TimerTask;

public class QAExecutor {
    // time interval in milliseconds after which records should be read again
    public static long interval = 1800000;

    public static void startTimer() {

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {

                RecordsManager.resetRecords();
            }
        }, 0, interval);
    }

}