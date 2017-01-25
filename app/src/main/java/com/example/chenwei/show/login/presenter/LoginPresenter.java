package com.example.chenwei.show.login.presenter;

import com.example.chenwei.show.login.model.ILoginModel;
import com.example.chenwei.show.login.model.LoginModel;
import com.example.chenwei.show.login.model.User;
import com.example.chenwei.show.login.view.ILoginView;

/**
 * Created by chenwei on 17/1/25.
 */

public class LoginPresenter implements ILoginPresenter {

    private ILoginModel iLoginModel;
    private ILoginView iLoginView;

    public LoginPresenter(ILoginView iLoginView) {
        this.iLoginView = iLoginView;
        iLoginModel = new LoginModel(this);
    }

    @Override
    public void login(User user) {
        iLoginView.showProgress(true);
        iLoginModel.login(user);
    }

    @Override
    public void loginSuccess() {
        iLoginView.showProgress(false);
        iLoginView.toMainActivity();
    }

    @Override
    public void loginFailed() {
        iLoginView.showProgress(false);
        iLoginView.showFailToast();
    }

    @Override
    public void register(User user) {

    }
}
