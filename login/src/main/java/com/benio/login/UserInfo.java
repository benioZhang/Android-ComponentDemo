package com.benio.login;

public class UserInfo {
    private String userId;
    private String username;

    public UserInfo(String userId, String username) {
        this.userId = userId;
        this.username = username;
    }

    public String getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }
}
