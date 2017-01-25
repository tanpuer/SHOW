package com.example.chenwei.show.download.view;

/**
 * Created by chenwei on 17/1/25.
 */

//view 接口定义所有需要实现的 视图 逻辑
public interface IDownloadView {

    //显示进度条
    void showProgressBar(boolean show);

    //设置进度条进度
    void setProcessProgress(int progress);

    //根据数据设置view
    void setView(String result);

    //设置失败的view
    void setFailToast();
}
