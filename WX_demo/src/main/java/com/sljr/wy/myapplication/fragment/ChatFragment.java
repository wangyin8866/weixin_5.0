package com.sljr.wy.myapplication.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.sljr.wy.myapplication.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Raymond on 2016/4/12.
 */
public class ChatFragment extends Fragment {
    private ViewPager mViewPager;
    private View mView;
    private int[] imageIds = {
            R.mipmap.landing_8, R.mipmap.landing_9, R.mipmap.landing_10, R.mipmap.landing_11
    };
    //定义一个list来存放View
    private List<View> views;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.chatfragment, container, false);
        Bundle bundle = getArguments();
        bundle.putString("wq","wangqin");
        Toast.makeText(getActivity(), bundle.getString("wy"), Toast.LENGTH_SHORT).show();
        initView();
        initData();
        Display display = getActivity().getWindowManager().getDefaultDisplay();


        return mView;
    }

    private void initData() {

        //定义一个布局文件并设置参数
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        for (int i = 0; i < imageIds.length; i++) {
            ImageView iv = new ImageView(getActivity());
            iv.setLayoutParams(params);
            //防止图片不能铺满屏幕
            iv.setScaleType(ImageView.ScaleType.FIT_XY);
            //加载图片资源
            iv.setImageResource(imageIds[i]);
            views.add(iv);
        }
        //设置数据
        mViewPager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return views.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            /**
             * 销毁position位置的界面
             */
            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {

                container.removeView(views.get(position));
            }

            /**
             * 初始化position位置的界面
             */
            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                container.addView(views.get(position), 0);
                return views.get(position);
            }
        });
    }

    private void initView() {
        mViewPager = (ViewPager) mView.findViewById(R.id.id_chat_viewPager);
        views = new ArrayList<>();
    }
}
