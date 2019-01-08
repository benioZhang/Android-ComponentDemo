package com.benio.share;

import com.benio.base.ApplicationDelegate;
import com.benio.componentservice.AppRouter;

public class ShareApp extends ApplicationDelegate {
    @Override
    public void onCreate() {
        super.onCreate();
        AppRouter.register(AppRouter.SHARE, new ShareRouteImpl());
    }
}