package com.benio.share.debug;

import com.benio.login.api.AccountService;

public class FakeLogoutService implements AccountService {
    @Override
    public boolean isLogin() {
        return false;
    }

    @Override
    public String getUserId() {
        return null;
    }

    @Override
    public String getUserName() {
        return null;
    }

    @Override
    public void logout() {
    }
}
