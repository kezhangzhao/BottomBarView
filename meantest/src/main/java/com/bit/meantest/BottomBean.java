package com.bit.meantest;

/**
 * author : zhangzhao.ke
 * time   : 2018/06/12
 * desc   : 底部菜单bean类
 */

public class BottomBean {

    private int ivSelectID;//选中图片id
    private int ivUnSelectID;//非选中图片id
    private String bottomText;//图片下面文字
    private int unReadNum;//未读数量


    public int getIvSelectID() {
        return ivSelectID;
    }

    public void setIvSelectID(int ivSelectID) {
        this.ivSelectID = ivSelectID;
    }

    public int getIvUnSelectID() {
        return ivUnSelectID;
    }

    public void setIvUnSelectID(int ivUnSelectID) {
        this.ivUnSelectID = ivUnSelectID;
    }

    public String getBottomText() {
        return bottomText;
    }

    public void setBottomText(String bottomText) {
        this.bottomText = bottomText;
    }

    public int getUnReadNum() {
        return unReadNum;
    }

    public void setUnReadNum(int unReadNum) {
        this.unReadNum = unReadNum;
    }
}
