package com.example.chenwei.show.login.presenter;

import com.example.chenwei.show.login.model.User;

/**
 * Created by chenwei on 17/1/25.
 */

public interface ILoginPresenter {

    void login(User user);

    void loginSuccess();

    void loginFailed();

    void register(User user);
}
