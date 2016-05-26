package com.honda.data;

/**
 * Created by John on 4/20/2016.
 */
public class Voucher {
    private String title;
    private int imgRes;
    private String content;
    private boolean isNegotiated;

    public Voucher() {

    }

    public Voucher(int imgRes) {
        this.imgRes = imgRes;
    }

    public Voucher(String title, int imgRes, String content, boolean isNegotiated) {
        this.title = title;
        this.imgRes = imgRes;
        this.content = content;
        this.isNegotiated = isNegotiated;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isNegotiated() {
        return isNegotiated;
    }

    public void setNegotiated(boolean negotiated) {
        isNegotiated = negotiated;
    }

    public int getImgRes() {
        return imgRes;
    }

    public void setImgRes(int imgRes) {
        this.imgRes = imgRes;
    }
}
