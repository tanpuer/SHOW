package com.example.chenwei.show.login.model;
import android.os.Looper;
import android.support.annotation.UiThread;
import android.widget.Toast;

import com.example.chenwei.show.login.presenter.ILoginPresenter;

/**
 * Created by chenwei on 17/1/25.
 */

public class LoginModel implements ILoginModel {

    private ILoginPresenter iLoginPresenter;

    public LoginModel(ILoginPresenter iLoginPresenter) {
        this.iLoginPresenter = iLoginPresenter;
    }

    @Override
    public void login(final User user) {
        //模拟
        new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if ("chenwei".equals(user.getUserName()) && "123456".equals(user.getPassport())){
                    iLoginPresenter.loginSuccess();
                }else {
                    iLoginPresenter.loginFailed();
                }
            }
        }.start();
    }

    @Override
    public void register(User user) {

    }
}
