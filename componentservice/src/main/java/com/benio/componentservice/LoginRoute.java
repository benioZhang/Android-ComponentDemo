package com.benio.componentservice;

import android.app.Activity;

public interface LoginRoute extends IRoute {
    void login(Activity activity, int requestCode);
}
