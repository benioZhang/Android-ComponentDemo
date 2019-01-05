package com.benio.login;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.benio.base.BaseActivity;

public class LoginActivity extends BaseActivity {
    private EditText mAccountEditText;
    private EditText mPwdEditText;
    private Handler mHandler = new Handler();
    private ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity_login);
        mAccountEditText = findViewById(R.id.et_login_account);
        mPwdEditText = findViewById(R.id.et_login_pwd);
        findViewById(R.id.btn_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }

    private void login() {
        final String account = mAccountEditText.getText().toString();
        final String pwd = mPwdEditText.getText().toString();
        if (TextUtils.isEmpty(account)) {
            Toast.makeText(this, R.string.login_error_account_empty, Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(pwd)) {
            Toast.makeText(this, R.string.login_error_account_empty, Toast.LENGTH_SHORT).show();
            return;
        }

        showLoading();
        // 模拟登录
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                hideLoading();
                Toast.makeText(LoginActivity.this, R.string.login_login_success, Toast.LENGTH_SHORT).show();
                UserInfoHolder.getInstance().login(new UserInfo("10000", account));
                setResult(RESULT_OK);
                finish();
            }
        }, 800);
    }

    private void showLoading() {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(this);
            mProgressDialog.setMessage("登录中...");
        }
        mProgressDialog.show();
    }

    private void hideLoading() {
        if (mProgressDialog != null) {
            mProgressDialog.dismiss();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        hideLoading();
        mProgressDialog = null;
        mHandler.removeCallbacksAndMessages(null);
    }
}
