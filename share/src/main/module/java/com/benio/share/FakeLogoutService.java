package com.benio.share;

import com.benio.componentservice.AccountService;

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
}
