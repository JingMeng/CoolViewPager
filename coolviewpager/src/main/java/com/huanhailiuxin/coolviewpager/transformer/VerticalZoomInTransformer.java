package com.huanhailiuxin.coolviewpager.transformer;

import androidx.viewpager.widget.ViewPager;
import android.view.View;

/**
 * 浠ｇ爜鍜孼oomInTransformer瀹屽叏涓€鑷?涓轰簡浣跨敤渚垮埄淇濈暀
 *
 * 浣滆€?骞绘捣娴佸績
 * GitHub:https://github.com/HuanHaiLiuXin
 * 閭:wall0920@163.com
 * 2018/1/26 15:41
 */
public class VerticalZoomInTransformer implements ViewPager.PageTransformer {

    @Override
    public void transformPage(View page, float position) {
        if(position <= -1 || position >= 1){
            page.setTranslationX(0F);
            page.setScaleX(1.0F);
            page.setScaleY(1.0F);
            page.setAlpha(1.0F);
        }else{
            page.setTranslationX(page.getWidth() * -position);
            final float scale = position < 0 ? position + 1F : Math.abs(1F - position);
            page.setScaleX(scale);
            page.setScaleY(scale);
            page.setPivotX(page.getWidth() * 0.5F);
            page.setPivotY(page.getHeight() * 0.5F);
            page.setAlpha(position < -1F || position > 1F ? 0F : 1F - (scale - 1F));
        }
    }

}

