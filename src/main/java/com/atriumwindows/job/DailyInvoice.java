package com.atriumwindows.job;

import com.atriumwindows.pdf.ProcessInvoice;

import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by nni on 2/1/2016.
 */
public class DailyInvoice implements Runnable{
    @Override
    public void run() {
        ProcessInvoice processInvoice = new ProcessInvoice();

        //get yesterday's date
        Calendar c = new GregorianCalendar();
        c.add(Calendar.DATE, -1);
        c.set(Calendar.HOUR_OF_DAY, 0); //anything 0 - 23
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        Date date = new Date(c.getTime().getTime());

        //process invoice for specific date
        processInvoice.processInvoice(date);

        /* LOGGER: TO DO
        * What Date, When*/
    }
}
