package com.benio.share;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.benio.base.BaseActivity;
import com.benio.componentservice.AccountService;
import com.benio.componentservice.ServiceManager;

public class ShareActivity extends BaseActivity implements View.OnClickListener {
    private TextView mUserView;
    private EditText mEditText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.share_activity_share);

        mUserView = findViewById(R.id.tv_share_user);
        mEditText = findViewById(R.id.et_share_content);
        final Button btn = findViewById(R.id.btn_share);
        btn.setOnClickListener(this);
        btn.setEnabled(false);
        mEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                btn.setEnabled(s.length() > 0);
            }
        });
        mEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                // Check if this was the result of hitting the enter key
                final boolean isSoftImeEvent = event == null
                        && (actionId == EditorInfo.IME_NULL
                        || actionId == EditorInfo.IME_ACTION_DONE);
                final boolean isKeyboardEnterKey = event != null
                        && event.getAction() == KeyEvent.ACTION_DOWN
                        && event.getKeyCode() == KeyEvent.KEYCODE_ENTER;

                if (isSoftImeEvent || isKeyboardEnterKey) {
                    share();
                    return true;
                }
                return false;
            }
        });
        AccountService accountService = ServiceManager.getService(ServiceManager.ACCOUNT_SERVICE);
        if (accountService != null && accountService.isLogin()) {
            mUserView.setText(accountService.getUserName());
        } else {
            mUserView.setText(R.string.share_logout);
        }
    }

    @Override
    public void onClick(View v) {
        // 注意：单独调试的时候,id是static final的，所以可以用switch
        // 当时继承调试的时候，id是static的，是不能通过编译的
        // 所以在module内只能用if，不要用switch!!!!!!!!!!!
        int id = v.getId();
        if (id == R.id.btn_share) {
            share();
        }
    }

    private void share() {
        AccountService accountService = ServiceManager.getService(ServiceManager.ACCOUNT_SERVICE);
        if (accountService == null || !accountService.isLogin()) {
            Toast.makeText(this, R.string.share_failed_while_logout, Toast.LENGTH_SHORT).show();
            return;
        }
        String content = mEditText.getText().toString();
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_TEXT, getString(R.string.share_content, accountService.getUserName(), content));
        intent.setType("text/plain");
        startActivity(Intent.createChooser(intent, getText(R.string.share_to)));
    }
}
