package com.example.shopmanagerment.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Check {
    public static boolean checkDateFormat(String target) {
        String dateFormatRegex = "^\\d{2}/\\d{2}/\\d{4}$";
        Pattern pattern = Pattern.compile(dateFormatRegex);
        Matcher matcher = pattern.matcher(target.trim());

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(target);
            return matcher.matches();
        } catch (ParseException e) {
            return false;
        }
    }

    public static boolean isBornToday(Date target) {
        // Lấy ngày hôm nay
        LocalDate today = LocalDate.now();

        // Chuyển đổi Date thành LocalDate
        LocalDate localDate = target.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        // Kiểm tra nếu localDate là ngày hôm nay
        return localDate.getDayOfMonth() == today.getDayOfMonth() &&
                localDate.getMonth() == today.getMonth();
    }
}
