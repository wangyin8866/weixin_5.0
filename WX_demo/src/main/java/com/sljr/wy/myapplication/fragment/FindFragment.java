package com.sljr.wy.myapplication.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sljr.wy.myapplication.R;

/**
 * Created by Raymond on 2016/4/12.
 */
public class FindFragment extends Fragment{
    private TextView mTextView;
    private View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.findfragment, container, false);
        mTextView = (TextView) view.findViewById(R.id.find_text);
                Bundle bundle = getArguments();
        mTextView.setText(bundle.getString("wq"));

        return view;
    }
}
