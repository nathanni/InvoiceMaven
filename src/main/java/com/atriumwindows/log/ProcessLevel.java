package com.atriumwindows.log;

import org.apache.log4j.Level;

/**
 * Created by nni on 7/20/2016.
 */
public class ProcessLevel extends Level {
    protected ProcessLevel(int level, String levelStr, int syslogEquivalent) {
        super(level, levelStr, syslogEquivalent);
    }
}
