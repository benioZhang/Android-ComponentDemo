package com.benio.share.debug;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.benio.base.BaseActivity;
import com.benio.componentservice.ServiceManager;
import com.benio.login.api.AccountService;
import com.benio.share.ShareActivity;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.share_activity_main);
        findViewById(R.id.btn_share_login).setOnClickListener(this);
        findViewById(R.id.btn_share_logout).setOnClickListener(this);
        findViewById(R.id.btn_share_not_registered).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_share_login:
                ServiceManager.registerService(AccountService.class, new FakeLoginService());
                startActivity(new Intent(this, ShareActivity.class));
                break;
            case R.id.btn_share_logout:
                ServiceManager.registerService(AccountService.class, new FakeLogoutService());
                startActivity(new Intent(this, ShareActivity.class));
                break;
            case R.id.btn_share_not_registered:
                startActivity(new Intent(this, ShareActivity.class));
                break;
        }
    }
}
