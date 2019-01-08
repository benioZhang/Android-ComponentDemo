package com.benio.login;

import android.app.Activity;
import android.content.Intent;

import com.benio.componentservice.LoginRoadMap;

public class LoginRoadMapImpl implements LoginRoadMap {
    @Override
    public void login(Activity activity, int requestCode) {
        Intent intent = new Intent(activity, LoginActivity.class);
        activity.startActivityForResult(intent, requestCode);
    }
}
