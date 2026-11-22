package com.huanhailiuxin.coolviewpager.adapter;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;

/**
 * 浣滆€?骞绘捣娴佸績
 * GitHub:https://github.com/HuanHaiLiuXin
 * 閭:wall0920@163.com
 * 2018/1/4 14:28
 */

public class LoopPagerAdapterWrapper extends PagerAdapter {
    private PagerAdapter mAdapter;
    private SparseArray mViewArray = new SparseArray();

    public LoopPagerAdapterWrapper(PagerAdapter adapter){
        this.mAdapter = adapter;
    }

    @Override
    public int getCount() {
        return mAdapter.getCount() + 2;
    }
    public int getRealCount(){
        return mAdapter.getCount();
    }
    public int toRealPosition(int position){
        int realCount = getRealCount();
        if(realCount == 0){
           return 0;
        }else{
            int realPosition = (position - 1)%realCount;
            if(realPosition < 0){
                realPosition += realCount;
            }
            return realPosition;
        }
    }
    public int toInnerPosition(int realPosition){
        int position = realPosition + 1;
        return position;
    }
    public int getRealFirstPosition(){
        return 1;
    }
    public int getRealLastPosition(){
        return getRealFirstPosition() + getRealCount() - 1;
    }
    public PagerAdapter getRealAdapter(){
        return mAdapter;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return mAdapter.isViewFromObject(view,object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        int realPosition = toRealPosition(position);
        Object item = mAdapter.instantiateItem(container, realPosition);
        int childCount = container.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = container.getChildAt(i);
            if (isViewFromObject(child, item)) {
                mViewArray.put(realPosition, child);
                break;
            }
        }
        return item;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        /*int realPosition = toRealPosition(position);
        mAdapter.destroyItem(container,realPosition,object);
        mViewArray.remove(realPosition);*/
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

    public Object getPageFromVPChild(View child){
        int key = indexOfValue(child);
        if(key < 0){
            return null;
        }else{
            return getViewAtRealPosition(key);
        }
    }
    public int indexOfValue(Object value){
        return mViewArray.indexOfValue(value);
    }
    public View getViewAtRealPosition(int position) {
        return (View) mViewArray.get(position);
    }
}
