package org.example.utils;

import org.apache.commons.lang3.StringUtils;

import java.time.LocalDateTime;

public class StringUtilsLocal {

    public static String getCapitalizedMonthName(LocalDateTime input) {
        return StringUtils.capitalize(input.getMonth().name().toLowerCase());
    }
}
