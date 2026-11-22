package com.huanhailiuxin.coolviewpager.transformer;

import androidx.viewpager.widget.ViewPager;
import android.view.View;

/**
 * 瀵瑰簲RotateTransformer,VerticalRotateTransformer閫傜敤浜嶤oolViewPager鍦ㄥ瀭鐩存柟鍚戞粴鍔ㄧ殑鎯呭喌
 *
 * 浣滆€?骞绘捣娴佸績
 * GitHub:https://github.com/HuanHaiLiuXin
 * 閭:wall0920@163.com
 * 2018/1/26 11:45
 */
public class VerticalRotateTransformer implements ViewPager.PageTransformer {
    private float MAX_ROTATE = 90F;

    @Override
    public void transformPage(View page, float position) {
        page.setTranslationX(page.getWidth() * -position);
        page.setTranslationY(page.getHeight() * position);
        page.setCameraDistance(10000F);
        if(position < -1){
            page.setRotationX(0F);
        }else if(position <= 0){
            page.setPivotX(page.getWidth()/2);
            page.setPivotY(page.getHeight());
            page.setRotationX(MAX_ROTATE * -position);
        }else if(position <= 1){
            page.setPivotX(page.getWidth()/2);
            page.setPivotY(0F);
            page.setRotationX(MAX_ROTATE * -position);
        }else {
            page.setRotationX(0F);
        }
    }
}

