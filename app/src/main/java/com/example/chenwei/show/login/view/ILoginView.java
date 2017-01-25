package com.example.chenwei.show.login.view;

/**
 * Created by chenwei on 17/1/25.
 */

public interface ILoginView {

    void showProgress(boolean show);

    void toMainActivity();

    void showFailToast();
}
