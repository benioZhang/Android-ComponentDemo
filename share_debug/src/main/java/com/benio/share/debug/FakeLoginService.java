package com.benio.share.debug;

import com.benio.login.api.AccountService;

public class FakeLoginService implements AccountService {
    @Override
    public boolean isLogin() {
        return true;
    }

    @Override
    public String getUserId() {
        return "100100";
    }

    @Override
    public String getUserName() {
        return "benio";
    }

    @Override
    public void logout() {

    }
}
