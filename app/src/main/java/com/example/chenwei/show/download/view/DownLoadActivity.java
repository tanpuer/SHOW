package com.example.chenwei.show.download.view;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.chenwei.show.R;
import com.example.chenwei.show.download.presenter.DownloadPresenter;

/**
 * Created by chenwei on 17/1/25.
 */

public class DownLoadActivity extends AppCompatActivity implements IDownloadView{

    private Context mContext;
    private ImageView mImageView;
    private ProgressDialog mProgressDialog;

    private DownloadPresenter mDownloadPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download);
        mContext = this;
        init();
    }

    private void init() {
        mDownloadPresenter = new DownloadPresenter(this);

        mImageView = (ImageView) findViewById(R.id.img_download);
        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDownloadPresenter.download("");
            }
        });

        mProgressDialog = new ProgressDialog(mContext);
        mProgressDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "cancel", new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                mProgressDialog.dismiss();
            }
        });
        mProgressDialog.setCanceledOnTouchOutside(false);
        mProgressDialog.setTitle("正在下载");
        mProgressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
    }

    @Override
    public void showProgressBar(boolean show) {
        if (show){
            mProgressDialog.show();
        }else {
            mProgressDialog.dismiss();
        }
    }

    @Override
    public void setProcessProgress(int progress) {
        mProgressDialog.setProgress(progress);
    }

    @Override
    public void setView(String result) {
        Glide.with(mContext).load(result).into(mImageView);
    }

    @Override
    public void setFailToast() {
        Toast.makeText(mContext, "Download Failed", Toast.LENGTH_LONG).show();
    }
}
