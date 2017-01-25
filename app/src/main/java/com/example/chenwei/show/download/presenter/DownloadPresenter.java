package com.example.chenwei.show.download.presenter;

import com.example.chenwei.show.download.model.DownloadModel;
import com.example.chenwei.show.download.model.IDownloadModel;
import com.example.chenwei.show.download.view.IDownloadView;

/**
 * Created by chenwei on 17/1/25.
 */

//在presenter的具体实现中，业务相关的操作由model去完成，视图相关的由view去完成
public class DownloadPresenter implements IDownloadPresenter{
    private IDownloadModel mIDownloadModel;
    private IDownloadView mIDownloadView;

    public DownloadPresenter(IDownloadView iDownloadView){
        this.mIDownloadView = iDownloadView;
        mIDownloadModel = new DownloadModel(this);
    }

    @Override
    public void download(String url) {
        mIDownloadView.showProgressBar(true);
        mIDownloadModel.download(url);
    }

    @Override
    public void downloadSuccess(String result) {
        mIDownloadView.showProgressBar(false);
        mIDownloadView.setView(result);
    }

    @Override
    public void downloadProgress(int progress) {
        mIDownloadView.setProcessProgress(progress);
    }

    @Override
    public void downloadFail() {
        mIDownloadView.showProgressBar(false);
        mIDownloadView.setFailToast();
    }
}
