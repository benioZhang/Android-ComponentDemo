package com.benio.component.demo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.benio.base.BaseActivity;
import com.benio.componentservice.AppRouter;
import com.benio.componentservice.ServiceManager;
import com.benio.login.api.AccountService;
import com.benio.login.api.LoginRoute;
import com.benio.share.api.ShareRoute;

public class MainActivity extends BaseActivity implements View.OnClickListener {
    private static final int REQUEST_LOGIN = 0x1001;
    private static final int REQUEST_LOGIN_AND_SHARE = 0x1002;
    private TextView mUsernameView;
    private Button mLoginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mUsernameView = findViewById(R.id.tv_username);
        mLoginButton = findViewById(R.id.btn_login);
        mLoginButton.setOnClickListener(this);
        findViewById(R.id.btn_share).setOnClickListener(this);
        findViewById(R.id.btn_login_and_share).setOnClickListener(this);
        updateLoginState();
    }

    private void updateLoginState() {
        AccountService accountService = ServiceManager.getService(AccountService.class);
        if (accountService.isLogin()) {
            mUsernameView.setText(accountService.getUserName());
            mLoginButton.setText("注销");
        } else {
            mUsernameView.setText("未登录");
            mLoginButton.setText("登录");
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                loginOrLogout();
                break;
            case R.id.btn_share:
                share();
                break;
            case R.id.btn_login_and_share:
                loginAndShare();
                break;
        }
    }

    private void gotoShare() {
        AppRouter.get(ShareRoute.class).share(this);
    }

    private void gotoLogin(int requestCode) {
        AppRouter.get(LoginRoute.class).login(this, requestCode);
    }

    private void loginOrLogout() {
        AccountService accountService = ServiceManager.getService(AccountService.class);
        if (accountService.isLogin()) {
            accountService.logout();
            Toast.makeText(this, "注销成功", Toast.LENGTH_SHORT).show();
            updateLoginState();
        } else {
            gotoLogin(REQUEST_LOGIN);
        }
    }

    private void share() {
        AccountService accountService = ServiceManager.getService(AccountService.class);
        if (accountService.isLogin()) {
            gotoShare();
        } else {
            Toast.makeText(this, "请先登录", Toast.LENGTH_SHORT).show();
        }
    }

    private void loginAndShare() {
        AccountService accountService = ServiceManager.getService(AccountService.class);
        if (accountService.isLogin()) {
            // 已经登录，则直接去分享
            gotoShare();
        } else {
            // 否则先登录再分享
            gotoLogin(REQUEST_LOGIN_AND_SHARE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_LOGIN_AND_SHARE && resultCode == RESULT_OK) {
            updateLoginState();
            gotoShare();
        } else if (requestCode == REQUEST_LOGIN && resultCode == RESULT_OK) {
            updateLoginState();
        }
    }
}
