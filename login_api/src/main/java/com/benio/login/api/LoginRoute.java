package com.benio.login.api;

import android.app.Activity;

import com.benio.componentservice.IRoute;

public interface LoginRoute extends IRoute {
    void login(Activity activity, int requestCode);
}
