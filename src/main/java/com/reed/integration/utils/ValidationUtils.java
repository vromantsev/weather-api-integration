package com.reed.integration.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public final class ValidationUtils {

    private static final String PATTERN = "yyyy-MM-dd";

    private ValidationUtils() {}

    public static void checkArgs(Object... args) {
        if (args != null && args.length >= 1) {
            for (Object arg : args) {
                if (arg == null) {
                    throw new IllegalArgumentException("Argument mustn't be null!");
                }
            }
        } else {
            throw new IllegalArgumentException("Arguments must be provided!");
        }
    }

    public static void checkDateFormat(final String date) {
        final SimpleDateFormat format = new SimpleDateFormat(PATTERN);
        try {
            format.parse(date);
        } catch (ParseException e) {
            throw new IllegalArgumentException("Invalid date format!");
        }
    }
}
