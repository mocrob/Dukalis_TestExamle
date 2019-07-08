package ru.ftc.android.shifttemple.features.login.domain.model;

public final class User {

    private String sessionId;
    private String name;

    public User(String sessionId, String name) {
        this.sessionId = sessionId;
        this.name = name;
    }

    public String getSessionId() {
        return sessionId;
    }

    public String getName() {
        return name;
    }
}