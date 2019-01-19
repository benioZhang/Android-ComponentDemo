package com.benio.base;

import android.app.Application;
import android.content.res.Configuration;

import java.util.ServiceLoader;

public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        // SPI，Service Provider Interface
        ServiceLoader<ApplicationDelegate> delegates = ServiceLoader.load(ApplicationDelegate.class);
        for (ApplicationDelegate d : delegates) {
            ApplicationDelegateDispatcher.get().add(d);
        }
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
