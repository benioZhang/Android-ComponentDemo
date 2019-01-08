package com.benio.login;

import com.benio.base.ApplicationDelegate;
import com.benio.componentservice.AppRouter;
import com.benio.componentservice.ServiceManager;

public class LoginApp extends ApplicationDelegate {

    @Override
    public void onCreate() {
        super.onCreate();
        ServiceManager.registerService(ServiceManager.ACCOUNT_SERVICE,
                new AccountServiceImpl(UserInfoHolder.getInstance()));
        AppRouter.register(AppRouter.LOGIN, new LoginRoadMapImpl());
    }
}
