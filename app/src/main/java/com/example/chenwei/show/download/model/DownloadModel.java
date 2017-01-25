package com.example.chenwei.show.download.model;

import android.os.Handler;
import android.os.Message;
import android.provider.SyncStateContract;

import com.example.chenwei.show.download.presenter.IDownloadPresenter;

/**
 * Created by chenwei on 17/1/25.
 */

//mvp中 model的工作就是完成具体的业务操作，网络请求，数据持久化，增删改查等操作  同时model中又不会包含任何model
public class DownloadModel implements IDownloadModel{
    private IDownloadPresenter mIDownloadPresenter;
    private MyHandler myHandler = new MyHandler();

    public DownloadModel(IDownloadPresenter iDownloadPresenter){
        this.mIDownloadPresenter = iDownloadPresenter;
    }

    @Override
    public void download(String url) {

    }

    class MyHandler extends Handler{
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 300:{
                    int percent = msg.arg1;
                    if (percent < 100){
                        mIDownloadPresenter.downloadProgress(percent);
                    }else {
                        mIDownloadPresenter.downloadSuccess("");
                    }
                    break;
                }
                case 404:{
                    mIDownloadPresenter.downloadFail();
                }
                default:
                    break;
            }
        }
    }
}
