package com.huanhailiuxin.coolviewpager.adapter;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

/**
 * 浣滆€?骞绘捣娴佸績
 * GitHub:https://github.com/HuanHaiLiuXin
 * 閭:wall0920@163.com
 * 2018/1/24 9:20
 *
 * <p>
 *     閲嶅啓getItemPosition,瑙ｅ喅鍘熺敓PagerAdapter瀹炰緥璋冪敤{@link PagerAdapter#notifyDataSetChanged()},ViewPager鐣岄潰涓嶅埛鏂扮殑闂
 * </p>
 */

public class PagerAdapterWrapper extends PagerAdapter {
    private PagerAdapter mAdapter;
    public PagerAdapterWrapper(PagerAdapter adapter){
        this.mAdapter = adapter;
    }

    @Override
    public int getCount() {
        return mAdapter == null ? 0 : mAdapter.getCount();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return mAdapter.isViewFromObject(view,object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        return mAdapter.instantiateItem(container,position);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        mAdapter.destroyItem(container,position,object);
    }

    /**
     * 瑙ｅ喅鍘熺敓PagerAdapter瀹炰緥璋冪敤{@link PagerAdapter#notifyDataSetChanged()},ViewPager鐣岄潰涓嶅埛鏂扮殑闂
     * 璇﹁:http://www.07net01.com/program/642011.html
     *
     * @param object
     * @return
     */
    @Override
    public int getItemPosition(@NonNull Object object) {
        int mChildCount = getCount();
        if(mChildCount > 0){
            return POSITION_NONE;
        }
        return super.getItemPosition(object);
    }
}

