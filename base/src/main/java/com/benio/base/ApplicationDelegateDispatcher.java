package com.benio.base;

import android.content.res.Configuration;

import java.util.ArrayList;
import java.util.List;

public class ApplicationDelegateDispatcher {
    private static final ApplicationDelegateDispatcher INSTANCE = new ApplicationDelegateDispatcher();
    private final List<ApplicationDelegate> mDelegates = new ArrayList<>();

    public static ApplicationDelegateDispatcher get() {
        return INSTANCE;
    }

    public void add(ApplicationDelegate delegate) {
        if (delegate == null || mDelegates.contains(delegate)) {
            return;
        }
        mDelegates.add(delegate);
    }

    public void onCreate() {
        for (ApplicationDelegate d : mDelegates) {
            d.onCreate();
        }
    }

    public void onTerminate() {
        for (ApplicationDelegate d : mDelegates) {
            d.onTerminate();
        }
    }

    public void onConfigurationChanged(Configuration newConfig) {
        for (ApplicationDelegate d : mDelegates) {
            d.onConfigurationChanged(newConfig);
        }
    }

    public void onLowMemory() {
        for (ApplicationDelegate d : mDelegates) {
            d.onLowMemory();
        }
    }

    public void onTrimMemory(int level) {
        for (ApplicationDelegate d : mDelegates) {
            d.onTrimMemory(level);
        }
    }
}
