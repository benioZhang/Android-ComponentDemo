package com.benio.base;

import android.app.Application;
import android.content.res.Configuration;

public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ApplicationDelegateDispatcher.get().onCreate();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        ApplicationDelegateDispatcher.get().onTerminate();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        ApplicationDelegateDispatcher.get().onConfigurationChanged(newConfig);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        ApplicationDelegateDispatcher.get().onLowMemory();
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        ApplicationDelegateDispatcher.get().onTrimMemory(level);
    }
}
