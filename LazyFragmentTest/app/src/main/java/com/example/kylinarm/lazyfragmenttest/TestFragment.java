package com.example.kylinarm.lazyfragmenttest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Administrator on 2017/8/21.
 */

public class TestFragment extends Fragment{

    @InjectView(R.id.tv_content)
    TextView tvContent;

    private View view;
    private String str;

    private boolean isFristShowFragment = true;
    private boolean isVisibleToUser;
    private boolean isInitView = false;

    public static TestFragment newInstance(String str) {
        Bundle args = new Bundle();
        TestFragment fragment = new TestFragment();
        args.putString("str",str);
        fragment.setArguments(args);
        return fragment;
    }

    /**
     *  防止ViewPager预加载而设置懒加载,该方法调用在onCreat前
     * @return
     */
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        this.isVisibleToUser = isVisibleToUser;
        Log.v("lazy","setUserVisibleHint  " + isVisibleToUser);
        if (isFristShowFragment && isVisibleToUser && isInitView){
            setDataToView();
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        isInitView = true;
        str = getArguments().getString("str");
        Log.v("lazy","onCreateView  "+str);
        view = LayoutInflater.from(getActivity()).inflate(R.layout.layout_textview,null);
        ButterKnife.inject(this,view);
        if (isFristShowFragment && isVisibleToUser) {
            setDataToView();
        }
        return view;
    }

    private void setDataToView(){
        Log.v("lazy","setDataToView  "+str);
        isFristShowFragment = false;
        tvContent.setText(str);
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.v("lazy","onResume  "+str);
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.v("lazy","onPause  "+str);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.v("lazy","onDestroyView  "+str);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.v("lazy","onDestroy  "+str);
    }
}
