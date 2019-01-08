package com.benio.componentservice;

public interface AccountService {
    /**
     * 是否已经登录
     */
    boolean isLogin();

    /**
     * 获取登录用户的 userId
     */
    String getUserId();

    String getUserName();

    void logout();
}
