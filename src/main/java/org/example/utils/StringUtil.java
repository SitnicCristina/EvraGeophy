package org.example.utils;

import java.util.Random;
import java.util.UUID;

public class StringUtil {

    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    private static final String ALPHANUMERIC = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final String DOMAIN = "@gmail.com";

    private static final Random RANDOM = new Random();

    //Generate a random alphabetic string of given length
    public static String randomString(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
        }
        return sb.toString();
    }

    //Generate a random alphanumeric string
    public static String randomAlphanumeric(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(ALPHANUMERIC.charAt(RANDOM.nextInt(ALPHANUMERIC.length())));
        }
        return sb.toString();
    }

    //Generate a random Gmail address
    public static String randomEmail() {
        String localPart = randomAlphanumeric(10).toLowerCase();
        return localPart + DOMAIN;
    }
}
