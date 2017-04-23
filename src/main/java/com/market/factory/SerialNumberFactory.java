package com.market.factory;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SerialNumberFactory {
    private static long counter = 0;
    
    public static synchronized String getSequence() {
        String date = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String sequ = new DecimalFormat("0000").format(++counter);
        return date + sequ;
    }
 
    public Class<String> getObjectType() {
        return String.class;
    }
 
    public boolean isSingleton() {
        return false;
    }
 
    public static void reset() {
    	SerialNumberFactory.counter = 0;
    }
}
