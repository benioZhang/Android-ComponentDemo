package com.benio.login.api;

import com.benio.componentservice.IService;

public interface AccountService extends IService {
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
