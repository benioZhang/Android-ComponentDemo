package com.benio.share.api;

import android.content.Context;

import com.benio.componentservice.IRoute;

public interface ShareRoute extends IRoute {
    void share(Context context);
}
