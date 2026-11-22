package com.huanhailiuxin.coolviewpager.transformer;

import androidx.viewpager.widget.ViewPager;
import android.view.View;

/**
 * 浣滆€?骞绘捣娴佸績
 * GitHub:https://github.com/HuanHaiLiuXin
 * 閭:wall0920@163.com
 * 2018/1/26 11:41
 */
public class RotateTransformer implements ViewPager.PageTransformer {
    private float MAX_ROTATE = 90F;

    @Override
    public void transformPage(View page, float position) {
        page.setCameraDistance(10000F);
        if(position < -1){
            /*page.setPivotX(page.getWidth());
            page.setPivotY(page.getHeight()/2);
            page.setRotationY(-MAX_ROTATE);*/
        }else if(position <= 0){
            page.setPivotX(page.getWidth());
            page.setPivotY(page.getHeight()/2);
            page.setRotationY(MAX_ROTATE * position);
        }else if(position <= 1){
            page.setPivotX(0F);
            page.setPivotY(page.getHeight()/2);
            page.setRotationY(MAX_ROTATE * position);
        }else {
            /*page.setPivotX(0F);
            page.setPivotY(page.getHeight()/2);
            page.setRotationY(MAX_ROTATE);*/
        }
    }
}

