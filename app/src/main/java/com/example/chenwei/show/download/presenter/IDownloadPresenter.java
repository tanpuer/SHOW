package com.example.chenwei.show.download.presenter;

/**
 * Created by chenwei on 17/1/25.
 */
// presenter接口 作为连接model和view的桥梁
public interface IDownloadPresenter {

    void download(String url);

    void downloadSuccess(String result);

    void downloadProgress(int progress);

    void downloadFail();
}
