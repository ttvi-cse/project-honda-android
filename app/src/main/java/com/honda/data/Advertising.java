package com.honda.data;

/**
 * Created by John on 5/5/2016.
 */
public class Advertising {
    private String title;
    private int imgRes;
    private String content;

    public Advertising() {
    }

    public Advertising(String title, int imgRes, String content) {
        this.title = title;
        this.imgRes = imgRes;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImgRes() {
        return imgRes;
    }

    public void setImgRes(int imgRes) {
        this.imgRes = imgRes;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
