# 依赖方式
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  
  	dependencies {
	        implementation 'com.github.kezhangzhao:BottomBarView:1.0.0'
	}
 # 1、在XML布局文件添加：
	<com.bit.meantest.BottomBarView
        android:id="@+id/bottom_bar_view"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:background="@color/white" />
# 2、创建底部导航栏资源：（这里是项目自带的图片资源，不一样的可以更换）
    private List<BottomBean> getMeanData() {
        List<BottomBean> listBean = new ArrayList<>();
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
        return listBean;
    }
# 3、使用方法：	  
	//设置资源数据
	bottomBarView.setData(getMeanData());
	//初始化选中的点
        bottomBarView.setSelectPosition(TabSelection);
	//设置监听
        bottomBarView.setOnMyItemClickListener((view, position) -> {
            switch (position) {
                case 0:
                    break;
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
            }
        });
 
# 图片
![](https://github.com/kezhangzhao/BottomBarView/raw/master/screenshot/1.png)  
