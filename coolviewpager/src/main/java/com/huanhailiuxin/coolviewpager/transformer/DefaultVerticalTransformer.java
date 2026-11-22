package com.huanhailiuxin.coolviewpager.transformer;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;
import android.view.View;

/**
 * DefaultVerticalTransformer鏄疌oolViewPager鍦ㄥ瀭鐩存柟鍚戞粴鍔ㄧ殑鎯呭喌涓嬮粯璁ょ殑PageTransformer
 *
 * 浣滆€?骞绘捣娴佸績
 * GitHub:https://github.com/HuanHaiLiuXin
 * 閭:wall0920@163.com
 * 2018/1/16 11:31
 */

public class DefaultVerticalTransformer implements ViewPager.PageTransformer {
    @Override
    public void transformPage(@NonNull View page, float position) {
        page.setTranslationX(page.getWidth() * -position);
        page.setTranslationY(page.getHeight() * position);
    }
}

