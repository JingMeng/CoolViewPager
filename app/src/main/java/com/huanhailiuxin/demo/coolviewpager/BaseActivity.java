package com.huanhailiuxin.demo.coolviewpager;

import android.content.Intent;
import android.graphics.BitmapFactory;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.huanhailiuxin.coolviewpager.CoolViewPager;

/**
 * 浣滆€?骞绘捣娴佸績
 * GitHub:https://github.com/HuanHaiLiuXin
 * 閭:wall0920@163.com
 * 2018/6/1 16:15
 */
public class BaseActivity extends AppCompatActivity{
    public void jump(Class clazz){
        startActivity(new Intent(BaseActivity.this,clazz));
    }
    public View createImageView(int imgResId){
        ImageView imageView = new ImageView(this);
        imageView.setLayoutParams(new CoolViewPager.LayoutParams());
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 2;
        imageView.setImageBitmap(BitmapFactory.decodeResource(getResources(),imgResId,options));
        return imageView;
    }
}
