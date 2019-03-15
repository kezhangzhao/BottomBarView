package com.bit.meantest;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import java.util.List;

/**
 * author : zhangzhao.ke
 * time   : 2018/06/11
 * desc   : 底部菜单自定义view
 */

public class BottombarView extends LinearLayout {

    private Context mContext;
    private RecyclerView rvBottombar;
    private BottombarAdapter bottombarAdapter;
    private GridLayoutManager gridLayoutManager;

    public BottombarView(Context context) {
        super(context);
        mContext = context;
        initView();
    }

    public BottombarView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        initView();
    }

    /**
     * 初始化
     */
    private void initView() {
        LayoutInflater.from(mContext).inflate(R.layout.view_bottombar, this);
        rvBottombar = findViewById(R.id.rv_bottom_bar);
        gridLayoutManager = new GridLayoutManager(mContext, 4);
        rvBottombar.setLayoutManager(gridLayoutManager);
        bottombarAdapter = new BottombarAdapter(mContext);
        rvBottombar.setAdapter(bottombarAdapter);
        rvBottombar.setItemAnimator(new DefaultItemAnimator());
    }


    /**
     * 设置底部菜单数据
     * @param list 数据
     */
    public void setData(List<BottomBean> list) {
        if (list != null && list.size() > 0) {
            gridLayoutManager.setSpanCount(list.size());
            bottombarAdapter.setData(list);
        }
    }

    /**
     * 设置item点击事件
     *
     * @param listener OnMyItemClickListener
     */
    public void setOnMyItemClickListener(BottombarAdapter.OnMyItemClickListener listener) {
        bottombarAdapter.setOnMyItemClickListener(listener);
    }

    /**
     * 设置选中
     *
     * @param position 第几个
     */
    public void setSelectPosition(int position) {
        bottombarAdapter.setSelectPosition(position);
    }

    /**
     * 设置选中文字的颜色
     *
     * @param colorId 颜色id
     */
    public void setSelectTextColor(int colorId) {
        bottombarAdapter.setSelectTextColor(colorId);
    }

    /**
     * 设置未选中文字的颜色
     *
     * @param colorId 颜色id
     */
    public void setUnSelectTextColor(int colorId) {
        bottombarAdapter.setUnSelectTextColor(colorId);
    }

    /**
     * 设置未读消息数量
     *
     * @param position 底部菜单第几个
     * @param num      未读消息数量
     */
    public void setUnReadNum(int position, int num) {
        bottombarAdapter.setUnReadNum(position, num);
    }

    /**
     * 设置未读消息字体颜色
     *
     * @param colorId 颜色id
     */
    public void setUnReadNumTextColor(int colorId) {
        bottombarAdapter.setUnReadNumTextColor(colorId);
    }

    /**
     * 设置未读消息背景颜色
     *
     * @param background 背景资源
     */
    public void setUnReadNumBackground(int background) {
        bottombarAdapter.setUnReadNumBackground(background);
    }
}
