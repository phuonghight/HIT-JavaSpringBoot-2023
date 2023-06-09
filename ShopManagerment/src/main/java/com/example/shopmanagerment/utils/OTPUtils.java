package com.example.shopmanagerment.utils;

import java.util.Random;

public class OTPUtils {
    static int otpLength = 6;

    static String digits = "0123456789";

    public static String generateOTP() {
        Random random = new Random();
        StringBuilder otp = new StringBuilder();
        for (int i = 0; i < otpLength; i++) {
            int index = random.nextInt(digits.length());
            otp.append(digits.charAt(index));
        }
        return otp.toString();
    }
}
