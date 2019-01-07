package com.benio.base;

import android.content.res.Configuration;

public abstract class ApplicationDelegate {

    public void onCreate() {
    }

    public void onTerminate() {
    }

    public void onConfigurationChanged(Configuration newConfig) {
    }

    public void onLowMemory() {
    }

    public void onTrimMemory(int level) {
    }
}
