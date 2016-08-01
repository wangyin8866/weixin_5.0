package wy.com.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import wy.com.myapplication.Fragment.Tab1_Fragment;
import wy.com.myapplication.Fragment.Tab2_Fragment;
import wy.com.myapplication.Fragment.Tab4_Fragment;
import wy.com.myapplication.Fragment.Tab5_Fragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private static final String TAG = "MainActivity";
    private LinearLayout mLinearLayoutTab01, mLinearLayoutTab02, mLinearLayoutTab03, mLinearLayoutTab04, mLinearLayoutTab05;
    private ImageView mImageView01, mImageView02, mImageView03, mImageView04, mImageView05;
    private TextView mTextView01, mTextView02, mTextView04, mTextView05;
    private Tab1_Fragment tab1_fragment;
    private Tab2_Fragment tab2_fragment;
    private Tab4_Fragment tab4_fragment;
    private Tab5_Fragment tab5_fragment;
    /**
     * 用于对Fragment进行管理
     */
    private FragmentManager fragmentManager;
    /**
     * 保存当前显示的是第几页
     */
    private int currentPage = 0;

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("wy", currentPage);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate() called with: " + "savedInstanceState = [" + savedInstanceState + "]");
        if (null != savedInstanceState) {
            currentPage = savedInstanceState.getInt("wy");
        }
        init();
        fragmentManager = getSupportFragmentManager();
        tab1_fragment = (Tab1_Fragment) fragmentManager.findFragmentByTag("tab01");
        tab2_fragment = (Tab2_Fragment) fragmentManager.findFragmentByTag("tab02");
        tab4_fragment = (Tab4_Fragment) fragmentManager.findFragmentByTag("tab04");
        tab5_fragment = (Tab5_Fragment) fragmentManager.findFragmentByTag("tab05");
// 第一次启动时选中第0个tab
        setTabSelection(currentPage);
    }

    @Override
    public void onClick(View v) {
        resetButtonView();

        switch (v.getId()) {
            case R.id.ll_tab01:
                setTabSelection(0);
                currentPage = 0;
                break;
            case R.id.ll_tab02:
                setTabSelection(1);
                currentPage = 1;
                break;
            case R.id.ll_tab03:
                setTabSelection(2);
                currentPage = 2;
                break;
            case R.id.ll_tab04:
                setTabSelection(3);
                currentPage = 3;
                break;
            case R.id.ll_tab05:
                setTabSelection(4);
                currentPage = 4;
                break;
        }
    }


    private void setTabSelection(int index) {
// 每次选中之前先清楚掉上次的选中状态
        resetButtonView();
// 开启一个Fragment事务
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        // 先隐藏掉所有的Fragment，以防止有多个Fragment显示在界面上的情况
        hideFragments(transaction);
        switch (index) {
            case 0:
                mImageView01.setImageResource(R.mipmap.jinghua);
                mTextView01.setTextColor(Color.WHITE);
                if (tab1_fragment == null) {
                    // 如果tab1_fragment为空，则创建一个并添加到界面上
                    tab1_fragment = new Tab1_Fragment();
                    transaction.add(R.id.content_main, tab1_fragment, "tab01");
                } else {
                    // 如果tab1_fragment不为空，则直接将它显示出来
                    transaction.show(tab1_fragment);
                }

                break;
            case 1:
                mImageView02.setImageResource(R.mipmap.xintie);
                mTextView02.setTextColor(Color.WHITE);
                if (tab2_fragment == null) {
                    // 如果tab2_fragment为空，则创建一个并添加到界面上
                    tab2_fragment = new Tab2_Fragment();
                    transaction.add(R.id.content_main, tab2_fragment, "tab02");
                } else {
                    // 如果tab2_fragment不为空，则直接将它显示出来
                    transaction.show(tab2_fragment);
                }
                break;
            case 2:
                mImageView03.setImageResource(R.mipmap.add);
                startActivity(new Intent(MainActivity.this, GuanZhuActivity.class));
                finish();
                break;
            case 3:
                // 当点击了设置tab时，改变控件的图片和文字颜色
                mImageView04.setImageResource(R.mipmap.guanzhu);
                mTextView04.setTextColor(Color.WHITE);
                if (tab4_fragment == null) {
                    // 如果tab4_fragment为空，则创建一个并添加到界面上
                    tab4_fragment = new Tab4_Fragment();
                    transaction.add(R.id.content_main, tab4_fragment, "tab04");
                } else {
                    // 如果tab4_fragment不为空，则直接将它显示出来
                    transaction.show(tab4_fragment);
                }
                break;
            case 4:
                // 当点击了设置tab时，改变控件的图片和文字颜色
                mImageView05.setImageResource(R.mipmap.my);
                mTextView05.setTextColor(Color.WHITE);
                if (tab5_fragment == null) {
                    // 如果tab5_fragment为空，则创建一个并添加到界面上
                    tab5_fragment = new Tab5_Fragment();
                    transaction.add(R.id.content_main, tab5_fragment, "tab05");
                } else {
                    // 如果tab5_fragment不为空，则直接将它显示出来
                    transaction.show(tab5_fragment);
                }
                break;
        }
        transaction.commit();
    }

    private void init() {
        mLinearLayoutTab01 = (LinearLayout) findViewById(R.id.ll_tab01);
        mLinearLayoutTab02 = (LinearLayout) findViewById(R.id.ll_tab02);
        mLinearLayoutTab03 = (LinearLayout) findViewById(R.id.ll_tab03);
        mLinearLayoutTab04 = (LinearLayout) findViewById(R.id.ll_tab04);
        mLinearLayoutTab05 = (LinearLayout) findViewById(R.id.ll_tab05);
        mImageView01 = (ImageView) findViewById(R.id.iv_tab01);
        mImageView02 = (ImageView) findViewById(R.id.iv_tab02);
        mImageView03 = (ImageView) findViewById(R.id.iv_tab03);
        mImageView04 = (ImageView) findViewById(R.id.iv_tab04);
        mImageView05 = (ImageView) findViewById(R.id.iv_tab05);
        mTextView01 = (TextView) findViewById(R.id.tv_tab01);
        mTextView02 = (TextView) findViewById(R.id.tv_tab02);
        mTextView04 = (TextView) findViewById(R.id.tv_tab04);
        mTextView05 = (TextView) findViewById(R.id.tv_tab05);


        mLinearLayoutTab01.setOnClickListener(this);
        mLinearLayoutTab02.setOnClickListener(this);
        mLinearLayoutTab03.setOnClickListener(this);
        mLinearLayoutTab04.setOnClickListener(this);
        mLinearLayoutTab05.setOnClickListener(this);

    }


    private void resetButtonView() {
        mImageView01.setImageResource(R.mipmap.jinghua_press);
        mImageView02.setImageResource(R.mipmap.xintie_presss);
        mImageView03.setImageResource(R.mipmap.add);
        mImageView04.setImageResource(R.mipmap.guanzhu_press);
        mImageView05.setImageResource(R.mipmap.my_press);

        mTextView01.setTextColor(0xffF865A8);
        mTextView02.setTextColor(0xffF865A8);
        mTextView04.setTextColor(0xffF865A8);
        mTextView05.setTextColor(0xffF865A8);


    }


    /**
     * 将所有的Fragment都置为隐藏状态。
     *
     * @param transaction 用于对Fragment执行操作的事务
     */
    private void hideFragments(FragmentTransaction transaction) {
        if (tab1_fragment != null) {
            transaction.hide(tab1_fragment);
        }
        if (tab2_fragment != null) {
            transaction.hide(tab2_fragment);
        }
        if (tab4_fragment != null) {
            transaction.hide(tab4_fragment);
        }
        if (tab5_fragment != null) {
            transaction.hide(tab5_fragment);
        }
    }


}
