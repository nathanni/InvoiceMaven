package com.atriumwindows.log;

import org.apache.log4j.Logger;

/**
 * Created by nni on 7/20/2016.
 */
public class MyLogger {
    private static Logger log = Logger.getLogger(MyLogger.class);

    public void hist(Object pm_objLogInfo) {
        log.log(MyLogLevel.HISTORY_LEVEL, pm_objLogInfo);
    }

    public void proc(Object pm_objLogInfo) {
        log.log(MyLogLevel.PROCESS_LEVEL, pm_objLogInfo);
    }
}
