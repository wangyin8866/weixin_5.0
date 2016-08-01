package com.sljr.wy.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jauker.widget.BadgeView;
import com.sljr.wy.myapplication.fragment.ChatFragment;
import com.sljr.wy.myapplication.fragment.FindFragment;
import com.sljr.wy.myapplication.fragment.MoreFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity implements View.OnClickListener {
    private ViewPager mViewPager;
    private List<Fragment> mDatas;
    private FragmentPagerAdapter mdAdapter;
    private TextView mChatTextView, mFindTextView, mMoreTextView, mWyTextView;
    private BadgeView mBadgeView;
    private LinearLayout mChatLinearLayout;
    private ImageView mTabLine;
    private int mScreen1_3;
    private int mCurrentPageIndex;
    private ChatFragment chatFragment;
    private ChatFragment chatFragment2;
    private FindFragment findFragment;
    private MoreFragment moreFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        getScreen();
        mChatTextView.setOnClickListener(this);
        mFindTextView.setOnClickListener(this);
        mMoreTextView.setOnClickListener(this);
        mWyTextView.setOnClickListener(this);
    }

    //获取屏幕尺寸
    private void getScreen() {
        Display display = getWindowManager().getDefaultDisplay();
        DisplayMetrics outMetrics = new DisplayMetrics();
        display.getMetrics(outMetrics);
        mScreen1_3 = outMetrics.widthPixels / 4;
        ViewGroup.LayoutParams layoutParams = mTabLine.getLayoutParams();
        layoutParams.width = mScreen1_3;
        mTabLine.setLayoutParams(layoutParams);
    }

    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.id_viewPager);
        mChatTextView = (TextView) findViewById(R.id.id_chatTextVIew);
        mFindTextView = (TextView) findViewById(R.id.id_findTextView);
        mMoreTextView = (TextView) findViewById(R.id.id_moreTextView);
        mWyTextView = (TextView) findViewById(R.id.id_wyTextView);
        mChatLinearLayout = (LinearLayout) findViewById(R.id.id_ll_chat);
        mTabLine = (ImageView) findViewById(R.id.id_iv_tabLine);

        mDatas = new ArrayList<>();
        chatFragment = new ChatFragment();
        Bundle bundle = new Bundle();
        bundle.putString("wy", "wangyin");
        chatFragment.setArguments(bundle);


        findFragment = new FindFragment();
        findFragment.setArguments(bundle);

        moreFragment = new MoreFragment();
        moreFragment.setArguments(bundle);
        chatFragment2 = new ChatFragment();
        chatFragment2.setArguments(bundle);
        mDatas.add(chatFragment);
        mDatas.add(findFragment);
        mDatas.add(moreFragment);
        mDatas.add(chatFragment2);
        mdAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return mDatas.get(position);
            }

            @Override
            public int getCount() {
                return mDatas.size();
            }
        };
        mViewPager.setAdapter(mdAdapter);


        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                Log.e("tag", position + "," + positionOffset + "," + positionOffsetPixels);
                //设置tabLine的滑动效果
                LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) mTabLine.getLayoutParams();
                if (mCurrentPageIndex == 0 && position == 0) {//0->1
                    lp.leftMargin = (int) (mCurrentPageIndex * mScreen1_3 + positionOffset * mScreen1_3);
                } else if (mCurrentPageIndex == 1 && position == 0) {//1->0
                    lp.leftMargin = (int) (mCurrentPageIndex * mScreen1_3 + (positionOffset - 1) * mScreen1_3);
                } else if (mCurrentPageIndex == 1 && position == 1) {//1->2
                    lp.leftMargin = (int) (mCurrentPageIndex * mScreen1_3 + positionOffset * mScreen1_3);
                } else if (mCurrentPageIndex == 2 && position == 1) {//2->1
                    lp.leftMargin = (int) (mCurrentPageIndex * mScreen1_3 + (positionOffset - 1) * mScreen1_3);
                }
                mTabLine.setLayoutParams(lp);
            }

            @Override
            public void onPageSelected(int position) {
                //重置颜色
                resetTextView();
                switch (position) {
                    case 0:
                        if (mBadgeView != null) {
                            mChatLinearLayout.removeView(mBadgeView);
                        }
                        mBadgeView = new BadgeView(MainActivity.this);
                        mBadgeView.setBadgeCount(7);
                        mChatLinearLayout.addView(mBadgeView);
                        mChatTextView.setTextColor(Color.parseColor("#008000"));
                        break;
                    case 1:
                        mFindTextView.setTextColor(Color.parseColor("#008000"));
                        break;

                    case 2:
                        mMoreTextView.setTextColor(Color.parseColor("#008000"));
                        break;
                    case 3:
                        mWyTextView.setTextColor(Color.parseColor("#008000"));
                        break;

                }
                mCurrentPageIndex = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void resetTextView() {
        mChatTextView.setTextColor(Color.BLACK);
        mMoreTextView.setTextColor(Color.BLACK);
        mFindTextView.setTextColor(Color.BLACK);
        mWyTextView.setTextColor(Color.BLACK);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.id_chatTextVIew:
                //设置当前页面的位置
                mViewPager.setCurrentItem(0);


                break;
            case R.id.id_findTextView:
                mViewPager.setCurrentItem(1);
                break;
            case R.id.id_moreTextView:
                mViewPager.setCurrentItem(2);
                break;
            case R.id.id_wyTextView:
                mViewPager.setCurrentItem(3);
                break;
        }
    }
}
