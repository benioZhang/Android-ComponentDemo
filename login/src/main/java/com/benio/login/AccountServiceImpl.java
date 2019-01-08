package com.benio.login;

import com.benio.componentservice.AccountService;

public class AccountServiceImpl implements AccountService {

    private UserInfoHolder mUserInfoHolder;

    public AccountServiceImpl(UserInfoHolder userInfoHolder) {
        mUserInfoHolder = userInfoHolder;
    }

    @Override
    public boolean isLogin() {
        return mUserInfoHolder.isLogin();
    }

    @Override
    public String getUserId() {
        UserInfo userInfo = mUserInfoHolder.getUserInfo();
        return userInfo != null ? userInfo.getUserId() : null;
    }

    @Override
    public String getUserName() {
        UserInfo userInfo = mUserInfoHolder.getUserInfo();
        return userInfo != null ? userInfo.getUsername() : null;
    }

    @Override
    public void logout() {
        mUserInfoHolder.logout();
    }
}
