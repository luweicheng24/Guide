package com.gsww.www.guide;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {
    private ViewPager vp;
    private List<View> mList;
    private RelativeLayout main;
    private ViewPagerAdapter adapter;
    private LinearLayout dotLayout;
    private Button goStart;
    private Integer[] imgs = {R.drawable.splash_5, R.drawable.splash_6, R.drawable.splash_7};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mList = new ArrayList<>();
        initView();
        tagFirst();
    }

    private void tagFirst() {

        SharedPreferences sp = getApplication().getSharedPreferences("isFirst",MODE_PRIVATE);
        SharedPreferences.Editor editor  = sp.edit().putInt("isFirst",1);
        editor.commit();

        int isOK = sp.getInt("isFirst",0);
        Log.e("MainActivity", "tagFirst: 写入成功" +isOK);

    }

    private void initView() {
        vp = (ViewPager) findViewById(R.id.viewPager);
        main = (RelativeLayout) findViewById(R.id.main);
        dotLayout = new LinearLayout(this);
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 100);
        lp.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        dotLayout.setLayoutParams(lp);
        dotLayout.setGravity(Gravity.CENTER);
        main.addView(dotLayout);

        for (int i = 0; i < 3; i++) {
            ImageView img = new ImageView(this);
            img.setScaleType(ImageView.ScaleType.CENTER_CROP);
            if(i==0){
                img.setBackgroundResource(R.drawable.select);

            }else {
                img.setBackgroundResource(R.drawable.no_select);
            }
            LinearLayout.LayoutParams ilp = new LinearLayout.LayoutParams(20, 20);
            ilp.setMargins(10, 0, 0, 0);
            img.setLayoutParams(ilp);
            dotLayout.addView(img);
        }
        vp.setOnPageChangeListener(this);
        for (int i = 0; i < 3; i++) {
            View  one = getLayoutInflater().inflate(R.layout.splash_one,null);
            View  two = getLayoutInflater().inflate(R.layout.splash_two,null);
            View  three = getLayoutInflater().inflate(R.layout.splash_three,null);
            goStart = (Button) three.findViewById(R.id.goStart);
            goStart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(MainActivity.this,LoginActivity.class));
                    MainActivity.this.finish();
                }
            });
           /* ImageView img = new ImageView(this);
            img.setBackgroundResource(imgs[i]);
            img.setScaleType(ImageView.ScaleType.CENTER_CROP);
            ViewGroup.LayoutParams vlp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            img.setLayoutParams(vlp);*/
            mList.add(one);
            mList.add(two);
            mList.add(three);
        }
        adapter = new ViewPagerAdapter(mList);
        vp.setAdapter(adapter);
    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        for (int i = 0; i < 3; i++) {
            if(i == position){
                ((ImageView)dotLayout.getChildAt(i)).setBackgroundResource(R.drawable.select);
            }else{
                ((ImageView)dotLayout.getChildAt(i)).setBackgroundResource(R.drawable.no_select);
            }
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }


}
