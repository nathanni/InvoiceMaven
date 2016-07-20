package com.atriumwindows.log;

import org.apache.log4j.Level;
import org.apache.log4j.Priority;
import org.apache.log4j.net.SyslogAppender;

/**
 * Created by nni on 7/20/2016.
 */
public class MyLogLevel {
    public static final Level HISTORY_LEVEL = new HistoryLevel(Priority.OFF_INT, "HIST", SyslogAppender.LOG_LOCAL0);
    public static final Level PROCESS_LEVEL = new ProcessLevel(Priority.FATAL_INT, "PROC", SyslogAppender.LOG_LOCAL0);

}
