package com.huanhailiuxin.coolviewpager.transformer;

import androidx.viewpager.widget.ViewPager;
import android.view.View;

/**
 * 瀵瑰簲浠ｇ爜瀹剁殑RotateDownTransformer,VerticalRotateDownTransformer閫傜敤浜嶤oolViewPager鍦ㄥ瀭鐩存柟鍚戞粴鍔ㄧ殑鎯呭喌
 *
 * 浣滆€?骞绘捣娴佸績
 * GitHub:https://github.com/HuanHaiLiuXin
 * 閭:wall0920@163.com
 * 2018/1/26 14:18
 */
public class VerticalRotateDownTransformer implements ViewPager.PageTransformer {

	private static final float ROT_MOD = 75F;

	@Override
	public void transformPage(View page, float position) {
		if(position <= -1 || position >= 1){
			page.setRotation(0F);
		}else{
			final float width = page.getWidth();
			final float height = page.getHeight();
			final float rotation = ROT_MOD * position * -1.25F;
			page.setPivotX(width);
			page.setPivotY(height * 0.5F);
			page.setRotation(rotation);
		}
	}

}

