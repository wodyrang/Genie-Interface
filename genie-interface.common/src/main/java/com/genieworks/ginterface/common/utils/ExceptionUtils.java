package com.genieworks.ginterface.common.utils;

public class ExceptionUtils {

    public static String getStackTrace(Throwable throwable) {
        StringBuilder trace = new StringBuilder().append(throwable);

        for(StackTraceElement stackTraceElement : throwable.getStackTrace()) {
            trace.append("\tat ").append(stackTraceElement);
        }
        return trace.toString();
    }
}
