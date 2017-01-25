package com.example.chenwei.show.utils;

import android.app.Activity;
import android.os.Build;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by chenwei on 17/1/25.
 */

public class StatusBarUtil {
    public void setStatusBarColor(Activity activity, int colorResId){
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP){
            Window window = activity.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(colorResId);
        }
    }
}
