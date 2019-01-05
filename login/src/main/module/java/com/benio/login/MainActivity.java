package com.benio.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.benio.base.BaseActivity;

public class MainActivity extends BaseActivity implements View.OnClickListener {
    private static final int REQUEST_LOGIN = 0x0101;
    private TextView mUsernameView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity_main);
        mUsernameView = findViewById(R.id.tv_username);
        findViewById(R.id.btn_login).setOnClickListener(this);
        findViewById(R.id.btn_logout).setOnClickListener(this);
        updateLoginState();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                startActivityForResult(new Intent(this, LoginActivity.class), REQUEST_LOGIN);
                break;
            case R.id.btn_logout:
                logout();
                break;
        }
    }

    private void updateLoginState() {
        mUsernameView.setText(UserInfoHolder.getInstance().isLogin() ?
                UserInfoHolder.getInstance().getUserInfo().getUsername() :
                "未登录");
    }

    private void logout() {
        UserInfoHolder.getInstance().logout();
        Toast.makeText(this, R.string.login_logout_success, Toast.LENGTH_SHORT).show();
        updateLoginState();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_LOGIN && resultCode == RESULT_OK) {
            updateLoginState();
        }
    }
}
