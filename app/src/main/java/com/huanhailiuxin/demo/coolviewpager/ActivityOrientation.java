package com.huanhailiuxin.demo.coolviewpager;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.huanhailiuxin.coolviewpager.CoolViewPager;

import java.util.ArrayList;
import java.util.List;

public class ActivityOrientation extends BaseActivity {
    private CoolViewPager vp;
    MyAdapter adapter1;
    MyAdapter adapter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN|WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_orientation);
        getSupportActionBar().hide();
        initViews();
    }
    private void initViews(){
        List<View> items1 = new ArrayList<>();
        items1.add(createImageView(R.mipmap.i1));
        items1.add(createImageView(R.mipmap.i2));
        items1.add(createImageView(R.mipmap.i5));
        items1.add(createImageView(R.mipmap.i6));
        List<View> items2 = new ArrayList<>();
        items2.add(createImageView(R.mipmap.img3));
        items2.add(createImageView(R.mipmap.img5));
        items2.add(createImageView(R.mipmap.img6));
        items2.add(createImageView(R.mipmap.img7));
        adapter1 = new MyAdapter(items1);
        adapter2 = new MyAdapter(items2);
        //
        vp = findViewById(R.id.vp);
        vp.setScrollMode(CoolViewPager.ScrollMode.HORIZONTAL);
        vp.setAdapter(adapter1);
    }

    private int index = 0;
    public void buttonClick(View view) {
        if(index % 2 == 0){
            vp.setScrollMode(CoolViewPager.ScrollMode.VERTICAL);
            vp.setAdapter(adapter2);
            index = 1;
        }else{
            vp.setScrollMode(CoolViewPager.ScrollMode.HORIZONTAL);
            vp.setAdapter(adapter1);
            index = 0;
        }
    }


    static class MyAdapter extends PagerAdapter {
        private List<View> views;
        public MyAdapter(List<View> items){
            this.views = items;
        }

        @Override
        public int getCount() {
            return views.size();
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view == object;
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            //蹇呴』瑕佸厛鍒ゆ柇,鍚﹀垯鎶ラ敊:java.lang.IllegalStateException: The specified child already has a parent
            //ViewGroup鐨刟ddView锛堬級鏂规硶涓嶈兘娣诲姞涓€涓凡瀛樺湪鐖舵帶浠剁殑瑙嗗浘,鎵€浠ュ湪鎵ц鍓嶉渶瑕佸垽鏂娣诲姞鐨刅iew瀹炰緥鏄笉鏄瓨鍦ㄧ埗鎺т欢.
            //濡傛灉瀛樺湪鐖舵帶浠?闇€瑕佸叾鐖舵帶浠跺厛灏嗚View绉婚櫎鎺?鍐嶆墽琛宎ddView
            if(views.get(position).getParent() != null){
                ((ViewGroup)views.get(position).getParent()).removeView(views.get(position));
            }
            container.addView(views.get(position));
            return views.get(position);
        }
        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            container.removeView((View) object);
        }
    }
}

