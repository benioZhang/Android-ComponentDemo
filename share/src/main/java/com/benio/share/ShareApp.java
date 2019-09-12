package com.benio.share;

import com.benio.base.ApplicationDelegate;
import com.benio.componentservice.AppRouter;
import com.benio.share.api.ShareRoute;

public class ShareApp extends ApplicationDelegate {
    @Override
    public void onCreate() {
        super.onCreate();
        AppRouter.register(ShareRoute.class, new ShareRouteImpl());
    }
}