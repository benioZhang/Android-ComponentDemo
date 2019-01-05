package com.benio.login;

public class UserInfoHolder {
    private static UserInfoHolder sInstance;
    private UserInfo mUserInfo;

    public static UserInfoHolder getInstance() {
        if (sInstance == null) {
            sInstance = new UserInfoHolder();
        }
        return sInstance;
    }

    public UserInfo getUserInfo() {
        return mUserInfo;
    }

    public void login(UserInfo userInfo) {
        this.mUserInfo = userInfo;
    }

    public void logout() {
        this.mUserInfo = null;
    }

    public boolean isLogin() {
        return this.mUserInfo != null;
    }
}
