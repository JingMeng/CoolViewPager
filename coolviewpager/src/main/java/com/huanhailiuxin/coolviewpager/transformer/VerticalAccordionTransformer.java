package com.huanhailiuxin.coolviewpager.transformer;



import androidx.viewpager.widget.ViewPager;
import android.view.View;

/**
 * 瀵瑰簲浠ｇ爜瀹剁殑AccordionTransformer,VerticalAccordionTransformer閫傜敤浜嶤oolViewPager鍦ㄥ瀭鐩存柟鍚戞粴鍔ㄧ殑鎯呭喌
 *
 * 浣滆€?骞绘捣娴佸績
 * GitHub:https://github.com/HuanHaiLiuXin
 * 閭:wall0920@163.com
 * 2018/1/26 11:37
 */
public class VerticalAccordionTransformer implements ViewPager.PageTransformer {

    @Override
    public void transformPage(View page, float position) {
        page.setTranslationX(page.getWidth() * -position);
        page.setTranslationY(0F);
        if(position < -1 || position > 1){
            page.setScaleX(1F);
        }else{
            page.setPivotY(position < 0F ? 0F : page.getHeight());
            page.setScaleY(position < 0F ? 1F + position : 1F - position);
        }
    }

}
