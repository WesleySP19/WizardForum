package com.ForumWizard.Forum.utils;

public class Validator {

    public static boolean validateEmail(String email) {
        return email != null && email.contains("@") && email.contains(".");
    }

    public static boolean validateName(String name) {
        return name != null && !name.trim().isEmpty();
    }

    public static boolean validateContent(String content) {
        return content != null && !content.trim().isEmpty();
    }

    public static boolean validateMediaPath(String path) {
        return path != null && (path.endsWith(".jpg") || path.endsWith(".png") || path.endsWith(".mp4") || path.endsWith(".mp3"));
    }
}
