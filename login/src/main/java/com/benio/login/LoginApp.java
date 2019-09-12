package com.benio.login;

import com.benio.base.ApplicationDelegate;
import com.benio.componentservice.AppRouter;
import com.benio.componentservice.ServiceManager;
import com.benio.login.api.AccountService;
import com.benio.login.api.LoginRoute;

public class LoginApp extends ApplicationDelegate {

    @Override
    public void onCreate() {
        super.onCreate();
        ServiceManager.registerService(AccountService.class,
                new AccountServiceImpl(UserInfoHolder.getInstance()));
        AppRouter.register(LoginRoute.class, new LoginRouteImpl());
    }
}
