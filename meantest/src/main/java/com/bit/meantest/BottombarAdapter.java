package com.bit.meantest;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * author : zhangzhao.ke
 * time   : 2018/06/11
 * desc   : 自定义底部菜单
 */

public class BottombarAdapter extends RecyclerView.Adapter {

    private Context mContext;
    private LayoutInflater inflater ;
    private List<BottomBean> listBean;
    private int selectPosition=0;
    private OnMyItemClickListener listener;//item点击事件监听
    private int selectTextColor = R.color.theme;
    private int unSelectTextColor = R.color.black_33;
    private int unReadNumTextColor = R.color.white;
    private int unReadNumBackground= R.drawable.circle_red_unread_8dp;

    BottombarAdapter(Context context) {
        this.mContext = context;
        this.inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        createDefaultData();
    }

    private void createDefaultData(){
        listBean = new ArrayList<>();
        BottomBean bottomBean1 = new BottomBean();
        bottomBean1.setIvSelectID(R.drawable.bottom_news_orange);
        bottomBean1.setIvUnSelectID(R.drawable.bottom_news_gray);
        bottomBean1.setBottomText("消息");
        listBean.add(bottomBean1);
        BottomBean bottomBean2 = new BottomBean();
        bottomBean2.setIvSelectID(R.drawable.bottom_contact_orange);
        bottomBean2.setIvUnSelectID(R.drawable.bottom_contact_gray);
        bottomBean2.setBottomText("通讯录");
        listBean.add(bottomBean2);
        BottomBean bottomBean3 = new BottomBean();
        bottomBean3.setIvSelectID(R.drawable.bottom_work_orange);
        bottomBean3.setIvUnSelectID(R.drawable.bottom_work_gray);
        bottomBean3.setBottomText("工作");
        listBean.add(bottomBean3);
        BottomBean bottomBean4 = new BottomBean();
        bottomBean4.setIvSelectID(R.drawable.bottom_personal_orange);
        bottomBean4.setIvUnSelectID(R.drawable.bottom_personal_gray);
        bottomBean4.setBottomText("我的");
        listBean.add(bottomBean4);
    }

    /**
     * 设置底部菜单数据
     * @param list 数据
     */
    public void setData(List<BottomBean> list){
        listBean.clear();
        listBean.addAll(list);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(inflater.inflate(R.layout.bottom_bar_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        MyViewHolder viewHolder = (MyViewHolder) holder;
        BottomBean bottomBean = listBean.get(position);
        if (position==selectPosition) {
            viewHolder.ivPicture.setImageResource(bottomBean.getIvSelectID());
            viewHolder.tvTextStr.setTextColor(mContext.getResources().getColor(selectTextColor));
        }else {
            viewHolder.ivPicture.setImageResource(bottomBean.getIvUnSelectID());
            viewHolder.tvTextStr.setTextColor(mContext.getResources().getColor(unSelectTextColor));
        }
        if (bottomBean.getUnReadNum()!=0) {
            if (bottomBean.getUnReadNum()<100) {
                viewHolder.tvUnReadNum.setText(String.valueOf(bottomBean.getUnReadNum()));
                viewHolder.tvUnReadNum.setTextSize(TypedValue.COMPLEX_UNIT_DIP,10);
            }else {
                viewHolder.tvUnReadNum.setText("···");
                viewHolder.tvUnReadNum.setTextSize(TypedValue.COMPLEX_UNIT_DIP,13);
            }
            viewHolder.tvUnReadNum.setVisibility(View.VISIBLE);
        }else {
            viewHolder.tvUnReadNum.setVisibility(View.GONE);
        }
        viewHolder.tvTextStr.setText(bottomBean.getBottomText());
        viewHolder.tvUnReadNum.setTextColor(mContext.getResources().getColor(unReadNumTextColor));
        viewHolder.tvUnReadNum.setBackgroundResource(unReadNumBackground);
        if (listener!=null){//设置监听
            viewHolder.llItemView.setOnClickListener(view -> {
                listener.itemClick(view,position);
                setSelectPosition(position);
            });
        }
    }

    @Override
    public int getItemCount() {
        return listBean.size();
    }

    /**
     * item点击事件监听
     */
    public interface OnMyItemClickListener{
        void itemClick(View view, int position);
    }

    /**
     * 设置item监听
     * @param listener OnMyItemClickListener
     */
    public void setOnMyItemClickListener (OnMyItemClickListener listener){
        this.listener = listener;
    }


    public void setSelectPosition(int position){
        this.selectPosition = position;
        notifyDataSetChanged();
    }

    /**
     * 设置选中文字的颜色
     * @param colorId 颜色id
     */
    public void setSelectTextColor(int colorId){
        this.selectTextColor = colorId;
    }


    /**
     * 设置未选中文字的颜色
     * @param colorId 颜色id
     */
    public void setUnSelectTextColor(int colorId){
        this.unSelectTextColor = colorId;
    }

    /**
     * 设置未读消息数量
     * @param position 底部菜单第几个
     * @param num 未读消息数量
     */
    public void setUnReadNum(int position,int num){
        listBean.get(position).setUnReadNum(num);
        notifyDataSetChanged();
    }

    /**
     * 设置未读消息字体颜色
     * @param colorId 颜色id
     */
    public void setUnReadNumTextColor(int colorId){
        this.unReadNumTextColor= colorId;
    }

    /**
     * 设置未读消息背景颜色
     * @param background 背景资源
     */
    public void setUnReadNumBackground(int background){
        this.unReadNumBackground = background;
    }

    /**
     * adapter的ViewHolder
     */
    class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView ivPicture;
        TextView tvTextStr;
        TextView tvUnReadNum;
        LinearLayout llItemView;

        private MyViewHolder(View itemView) {
            super(itemView);
            ivPicture = itemView.findViewById(R.id.iv_picture);
            tvTextStr = itemView.findViewById(R.id.tv_text_str);
            tvUnReadNum = itemView.findViewById(R.id.tv_unread_num);
            llItemView = itemView.findViewById(R.id.ll_item_view);
        }
    }
}
