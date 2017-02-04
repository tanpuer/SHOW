package com.example.chenwei.show.utils;

import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.support.v4.view.animation.LinearOutSlowInInterpolator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.Interpolator;

/**
 * Created by chenwei on 17/2/3.
 */

public class AnimatorUtil {

    public static final LinearOutSlowInInterpolator FAST_OUT_SLOW_IN_INTERPOLATOR = new LinearOutSlowInInterpolator();
    
    //显示view动画
    public static void scaleShow(View view, ViewPropertyAnimatorListener viewPropertyAnimatorListener){
        view.setVisibility(View.VISIBLE);
        ViewCompat.animate(view)
                .scaleX(1.0f)
                .scaleY(1.0f)
                .alpha(1.0f)
                .setDuration(800)
                .setInterpolator(FAST_OUT_SLOW_IN_INTERPOLATOR)
                .setListener(viewPropertyAnimatorListener)
                .start();
    }

    //隐藏view动画
    public static void scaleHide(View view, ViewPropertyAnimatorListener viewPropertyAnimatorListener){
        ViewCompat.animate(view)
                .scaleX(0.0f)
                .scaleY(0.0f)
                .alpha(0.0f)
                .setDuration(800)
                .setInterpolator(FAST_OUT_SLOW_IN_INTERPOLATOR)
                .setListener(viewPropertyAnimatorListener)
                .start();
    }
}
