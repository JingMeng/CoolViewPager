package com.huanhailiuxin.coolviewpager.transformer;

import androidx.viewpager.widget.ViewPager;
import android.view.View;

/**
 * 瀵瑰簲浠ｇ爜瀹剁殑DepthPageTransformer,VerticalDepthPageTransformer閫傜敤浜嶤oolViewPager鍦ㄥ瀭鐩存柟鍚戞粴鍔ㄧ殑鎯呭喌
 *
 * 浣滆€?骞绘捣娴佸績
 * GitHub:https://github.com/HuanHaiLiuXin
 * 閭:wall0920@163.com
 * 2018/1/26 11:43
 */
public class VerticalDepthPageTransformer implements ViewPager.PageTransformer {

    private static final float MIN_SCALE = 0.75F;

    @Override
    public void transformPage(View page, float position) {
        page.setTranslationX(page.getWidth() * -position);
        page.setTranslationY(page.getHeight() * position);
        if (position < -1) {
        } else if (position <= 0F) {
            page.setAlpha(1.0F + position);
            page.setTranslationY(page.getHeight() * position);
            page.setScaleX(1F);
            page.setScaleY(1F);
        } else if (position <= 1F) {
            final float scaleFactor = MIN_SCALE + (1 - MIN_SCALE) * (1 - Math.abs(position));
            page.setAlpha(1 - position);
            page.setPivotY(0.5F * page.getHeight());
            page.setTranslationY(0F);
            page.setScaleX(scaleFactor);
            page.setScaleY(scaleFactor);
        } else {
        }
    }
}

