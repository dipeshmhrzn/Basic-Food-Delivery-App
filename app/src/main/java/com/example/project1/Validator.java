package com.example.project1;

public class Validator {
    public static boolean checkNum(String value) {
        return value.matches("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+");
    }

    public static boolean checkPassword(String value) {
        return value.matches("[a-zA-Z0-9\\\\!\\\\@\\\\#\\\\$]{8,24}");
    }

    public static boolean checkNotEmpty(String value) {
        return !value.isEmpty();
    }
}
