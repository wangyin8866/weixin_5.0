package wy.com.myapplication.Fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import wy.com.myapplication.R;

/**
 * Created by DELL on 2016/7/4.
 */
public class Tab1_Fragment extends Fragment implements View.OnClickListener {
    private View view;
    private TextView mTextView1, mTextView2, mTextView3, mTextView4, mTextView5, mTextView6, mTextView7, mTextView8, mTextView9, mTextView10;
    private HorizontalScrollView mHorizontalScrollView;//上面的水平滚动控件
    private ViewPager mViewPager;   //下方的可横向拖动的控件
    private ArrayList<Fragment> mFragments;//用来存放下方滚动的
    private ImageView mImageView1, mImageView2, mImageView3, mImageView4, mImageView5, mImageView6, mImageView7, mImageView8, mImageView9, mImageView10;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.jinghua_main, container, false);
        iniController();
        initViewPager();
        iniListener();
        mViewPager.setCurrentItem(0);

//        getScreen();


        return view;
    }


    private void initViewPager() {
        mFragments = new ArrayList<>();
        mFragments.add(new Tab1a_Fragment());
        mFragments.add(new Tab1b_Fragment());
        mFragments.add(new Tab1c_Fragment());
        mFragments.add(new Tab1d_Fragment());
        mFragments.add(new Tab1e_Fragment());
        mFragments.add(new Tab1f_Fragment());
        mFragments.add(new Tab1g_Fragment());
        mFragments.add(new Tab1h_Fragment());
        mFragments.add(new Tab1i_Fragment());
        mFragments.add(new Tab1j_Fragment());

        mViewPager.setAdapter(new MyPagerAdapter(getActivity().getSupportFragmentManager(), mFragments));//设置ViewPager的适配器
    }

    private void iniListener() {
        mTextView1.setOnClickListener(this);
        mTextView2.setOnClickListener(this);
        mTextView3.setOnClickListener(this);
        mTextView4.setOnClickListener(this);
        mTextView5.setOnClickListener(this);
        mTextView6.setOnClickListener(this);
        mTextView7.setOnClickListener(this);
        mTextView8.setOnClickListener(this);
        mTextView9.setOnClickListener(this);
        mTextView10.setOnClickListener(this);
        mViewPager.setOnPageChangeListener(new MyPagerOnPageChangeListener());
    }

    private void iniController() {
        mTextView1 = (TextView) view.findViewById(R.id.btn1);
        mTextView2 = (TextView) view.findViewById(R.id.btn2);
        mTextView3 = (TextView) view.findViewById(R.id.btn3);
        mTextView4 = (TextView) view.findViewById(R.id.btn4);
        mTextView5 = (TextView) view.findViewById(R.id.btn5);
        mTextView6 = (TextView) view.findViewById(R.id.btn6);
        mTextView7 = (TextView) view.findViewById(R.id.btn7);
        mTextView8 = (TextView) view.findViewById(R.id.btn8);
        mTextView9 = (TextView) view.findViewById(R.id.btn9);
        mTextView10 = (TextView) view.findViewById(R.id.btn10);


        mImageView1 = (ImageView) view.findViewById(R.id.id_iv1);
        mImageView2 = (ImageView) view.findViewById(R.id.id_iv2);
        mImageView3 = (ImageView) view.findViewById(R.id.id_iv3);
        mImageView4 = (ImageView) view.findViewById(R.id.id_iv4);
        mImageView5 = (ImageView) view.findViewById(R.id.id_iv5);
        mImageView6 = (ImageView) view.findViewById(R.id.id_iv6);
        mImageView7 = (ImageView) view.findViewById(R.id.id_iv7);
        mImageView8 = (ImageView) view.findViewById(R.id.id_iv8);
        mImageView9 = (ImageView) view.findViewById(R.id.id_iv9);
        mImageView10 = (ImageView) view.findViewById(R.id.id_iv10);
        mHorizontalScrollView = (HorizontalScrollView) view.findViewById(R.id.horizontalScrollView);
        mViewPager = (ViewPager) view.findViewById(R.id.pager);
    }


    private void resetTextView() {
        mTextView1.setTextColor(Color.BLACK);
        mTextView2.setTextColor(Color.BLACK);
        mTextView3.setTextColor(Color.BLACK);
        mTextView4.setTextColor(Color.BLACK);
        mTextView5.setTextColor(Color.BLACK);
        mTextView6.setTextColor(Color.BLACK);
        mTextView7.setTextColor(Color.BLACK);
        mTextView8.setTextColor(Color.BLACK);
        mTextView9.setTextColor(Color.BLACK);
        mTextView10.setTextColor(Color.BLACK);
        mImageView1.setBackgroundColor(Color.parseColor("#00000000"));
        mImageView2.setBackgroundColor(Color.parseColor("#00000000"));
        mImageView3.setBackgroundColor(Color.parseColor("#00000000"));
        mImageView4.setBackgroundColor(Color.parseColor("#00000000"));
        mImageView5.setBackgroundColor(Color.parseColor("#00000000"));
        mImageView6.setBackgroundColor(Color.parseColor("#00000000"));
        mImageView7.setBackgroundColor(Color.parseColor("#00000000"));
        mImageView8.setBackgroundColor(Color.parseColor("#00000000"));
        mImageView9.setBackgroundColor(Color.parseColor("#00000000"));
        mImageView10.setBackgroundColor(Color.parseColor("#00000000"));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn1:
                mViewPager.setCurrentItem(0);
                break;
            case R.id.btn2:
                mViewPager.setCurrentItem(1);
                break;
            case R.id.btn3:
                mViewPager.setCurrentItem(2);
                break;
            case R.id.btn4:
                mViewPager.setCurrentItem(3);
                break;
            case R.id.btn5:
                mViewPager.setCurrentItem(4);
                break;
            case R.id.btn6:
                mViewPager.setCurrentItem(5);
                break;
            case R.id.btn7:
                mViewPager.setCurrentItem(6);
                break;
            case R.id.btn8:
                mViewPager.setCurrentItem(7);
                break;
            case R.id.btn9:
                mViewPager.setCurrentItem(8);
                break;
            case R.id.btn10:
                mViewPager.setCurrentItem(9);
                break;
        }
    }

    private class MyPagerAdapter extends FragmentPagerAdapter {
        private List<Fragment> list;

        public MyPagerAdapter(FragmentManager fm, List<Fragment> list) {
            super(fm);
            this.list = list;
        }

        @Override
        public Fragment getItem(int position) {
            return list.get(position);
        }

        @Override
        public int getCount() {
            return list.size();
        }
    }

    private class MyPagerOnPageChangeListener implements ViewPager.OnPageChangeListener {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }

        @Override
        public void onPageSelected(int position) {
            resetTextView();
            switch (position) {
                case 0:
                    mTextView1.setTextColor(Color.parseColor("#008000"));
                    mImageView1.setBackgroundColor(Color.parseColor("#E61A5F"));
                    mHorizontalScrollView.smoothScrollTo(50 * position, 0);//使mHorizontalScrollView跟随滑动
                    break;
                case 1:
                    mTextView2.setTextColor(Color.parseColor("#008000"));
                    mImageView2.setBackgroundColor(Color.parseColor("#E61A5F"));
                    mHorizontalScrollView.smoothScrollTo(50 * position, 0);
                    break;
                case 2:
                    mTextView3.setTextColor(Color.parseColor("#008000"));
                    mImageView3.setBackgroundColor(Color.parseColor("#E61A5F"));
                    mHorizontalScrollView.smoothScrollTo(50 * position, 0);
                    break;
                case 3:
                    mTextView4.setTextColor(Color.parseColor("#008000"));
                    mImageView4.setBackgroundColor(Color.parseColor("#E61A5F"));
                    mHorizontalScrollView.smoothScrollTo(50 * position, 0);
                    break;
                case 4:
                    mTextView5.setTextColor(Color.parseColor("#008000"));
                    mImageView5.setBackgroundColor(Color.parseColor("#E61A5F"));
                    mHorizontalScrollView.smoothScrollTo(50 * position, 0);
                    break;
                case 5:
                    mTextView6.setTextColor(Color.parseColor("#008000"));
                    mImageView6.setBackgroundColor(Color.parseColor("#E61A5F"));
                    mHorizontalScrollView.smoothScrollTo(50 * position, 0);
                    break;
                case 6:
                    mTextView7.setTextColor(Color.parseColor("#008000"));
                    mImageView7.setBackgroundColor(Color.parseColor("#E61A5F"));
                    mHorizontalScrollView.smoothScrollTo(50 * position, 0);
                    break;
                case 7:
                    mTextView8.setTextColor(Color.parseColor("#008000"));
                    mImageView8.setBackgroundColor(Color.parseColor("#E61A5F"));
                    mHorizontalScrollView.smoothScrollTo(50 * position, 0);
                    break;
                case 8:
                    mTextView9.setTextColor(Color.parseColor("#008000"));
                    mImageView9.setBackgroundColor(Color.RED);
                    mHorizontalScrollView.smoothScrollTo(50 * position, 0);
                    break;
                case 9:
                    mTextView10.setTextColor(Color.parseColor("#008000"));
                    mImageView10.setBackgroundColor(Color.RED);
                    mHorizontalScrollView.smoothScrollTo(50 * position, 0);
                    break;
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }
}
