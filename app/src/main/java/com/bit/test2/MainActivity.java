package com.bit.test2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bit.meantest.BottomBarView;
import com.bit.meantest.BottomBean;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    BottomBarView bottomBarView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomBarView = findViewById(R.id.bottom_bar_view);
        bottomBarView.setData(createDefaultData());
    }

    private List<BottomBean> createDefaultData(){
      List<BottomBean> listBean = new ArrayList<>();
        BottomBean bottomBean1 = new BottomBean();
        bottomBean1.setIvSelectID(R.mipmap.bottom_news_orange);
        bottomBean1.setIvUnSelectID(R.mipmap.bottom_news_gray);
        bottomBean1.setBottomText("消息");
        listBean.add(bottomBean1);
        BottomBean bottomBean2 = new BottomBean();
        bottomBean2.setIvSelectID(R.mipmap.bottom_contact_orange);
        bottomBean2.setIvUnSelectID(R.mipmap.bottom_contact_gray);
        bottomBean2.setBottomText("通讯录");
        listBean.add(bottomBean2);
        BottomBean bottomBean3 = new BottomBean();
        bottomBean3.setIvSelectID(R.mipmap.bottom_work_orange);
        bottomBean3.setIvUnSelectID(R.mipmap.bottom_work_gray);
        bottomBean3.setBottomText("工作");
        listBean.add(bottomBean3);
        BottomBean bottomBean4 = new BottomBean();
        bottomBean4.setIvSelectID(R.mipmap.bottom_personal_orange);
        bottomBean4.setIvUnSelectID(R.mipmap.bottom_personal_gray);
        bottomBean4.setBottomText("我的");
        listBean.add(bottomBean4);
        return listBean;
    }
}
