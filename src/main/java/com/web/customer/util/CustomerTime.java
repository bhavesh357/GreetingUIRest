package com.web.customer.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CustomerTime {
    public static String getTimeStamp(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        return dtf.format(LocalDateTime.now());
    }
}
