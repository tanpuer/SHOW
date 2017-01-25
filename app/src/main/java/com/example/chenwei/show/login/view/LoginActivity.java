package com.example.chenwei.show.login.view;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.chenwei.show.MainActivity;
import com.example.chenwei.show.R;
import com.example.chenwei.show.login.model.User;
import com.example.chenwei.show.login.presenter.LoginPresenter;
import com.example.chenwei.show.utils.StatusBarUtil;

/**
 * Created by chenwei on 17/1/25.
 */

public class LoginActivity extends AppCompatActivity implements ILoginView{

    private EditText et_userName, et_password;
    private AppCompatButton btn_login;
    private ProgressDialog progressDialog;

    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
        new StatusBarUtil().setStatusBarColor(this, R.color.loginStatus);
    }

    private void init() {
        et_userName = (EditText) findViewById(R.id.et_username);
        et_password = (EditText) findViewById(R.id.et_password);
        btn_login = (AppCompatButton) findViewById(R.id.btn_login);

        loginPresenter = new LoginPresenter(this);

        progressDialog = new ProgressDialog(this);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.setTitle("正在登陆");

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = et_userName.getText().toString();
                String passport = et_password.getText().toString();
                loginPresenter.login(new User(userName, passport));
            }
        });

    }

    @Override
    public void showProgress(boolean show) {
        if (show){
            progressDialog.show();
        }else {
            progressDialog.dismiss();
        }
    }

    @Override
    public void toMainActivity() {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void showFailToast() {
        this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(LoginActivity.this, "登陆失败", Toast.LENGTH_LONG).show();
            }
        });
    }
}
