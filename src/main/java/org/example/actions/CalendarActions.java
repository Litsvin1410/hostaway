package org.example.actions;

import org.example.pages.popups.DatePicker;
import org.example.utils.StringUtilsLocal;

import java.time.LocalDateTime;
import java.time.Month;

public class CalendarActions {

    public static void setDate(LocalDateTime date) {

        DatePicker datePicker = new DatePicker();
        datePicker.waitTillClearAllButtonDisplayed();

        var monthName = StringUtilsLocal.getCapitalizedMonthName(date);
        var monthYearString = String.join(" ", monthName, String.valueOf(date.getYear()));
        var monthAmount = Month.values().length;


        while (monthAmount-- > 0) {
            if (datePicker.isMonthYearTitleDisplayed(monthName)) {
                System.out.println("Necessary month is found");
                break;
            } else {
                datePicker.clickArrowLeftButton();
            }
        }
        datePicker.clickDayByMonthAndYear(monthYearString, String.valueOf(date.getDayOfMonth()));
    }
}
