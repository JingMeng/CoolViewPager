package com.huanhailiuxin.coolviewpager;

import androidx.annotation.ColorInt;

/**
 * 浣滆€?骞绘捣娴佸績
 * GitHub:https://github.com/HuanHaiLiuXin
 * 閭:wall0920@163.com
 * 2018/1/17 20:52
 *
 * 涓篊oolViewPager鎻愪緵鑷畾涔夊睘鎬х殑璁剧疆鏂规硶
 */

interface ICoolViewPagerFeature {
    /**
     * 璁剧疆婊戝姩鏂瑰悜
     *
     * @param scrollMode
     */
    void setScrollMode(CoolViewPager.ScrollMode scrollMode);

    /**
     * 璁剧疆鏄惁寮€鍚嚜鍔ㄦ粴鍔?骞惰缃嚜鍔ㄦ粴鍔ㄦ椂闂撮棿闅?     *
     * @param autoScroll
     * @param intervalInMillis
     */
    void setAutoScroll(boolean autoScroll, int... intervalInMillis);



    /**
     * 璁剧疆鑷姩婊氬姩鏂瑰悜
     *
     * @param autoScrollDirection
     */
    void setAutoScrollDirection(CoolViewPager.AutoScrollDirection autoScrollDirection);

    /**
     * 鍦ㄨ嚜鍔ㄦ粴鍔ㄥ紑鍚儏鍐典笅,鑷姩婊氬姩鍒颁笅涓€椤?     */
    void autoScrollNextPage();

    /**
     * 璁剧疆鏄惁寰幆婊氬姩
     *
     * @param infiniteLoop
     */
    void setInfiniteLoop(boolean infiniteLoop);

    /**
     * 璁剧疆鏄惁缁樺埗EdgeEffect
     *
     * @param drawEdgeEffect
     */
    void setDrawEdgeEffect(boolean drawEdgeEffect);

    /**
     * 璁剧疆EdgeEffect鐨勯鑹?     *
     * @param color
     */
    void setEdgeEffectColor(@ColorInt int color);

    /**
     * 璁剧疆鏄惁鑷畾涔夎嚜鍔ㄦ粦鍔ㄨ€楁椂,骞惰缃嚜鍔ㄦ粦鍔ㄨ€楁椂姣鍊?     *
     * @param ifSetScrollDuration
     * @param scrollDuration
     */
    void setScrollDuration(boolean ifSetScrollDuration, int... scrollDuration);
}

