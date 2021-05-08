package com.example.tmall.credit.entity;

public class Rectify {
    private int rectify_id;
    private int service_id;
    private String rectify_situation;
    private int seller_id;

    public Rectify() {
    }

    public int getRectify_id() {
        return rectify_id;
    }

    public void setRectify_id(int rectify_id) {
        this.rectify_id = rectify_id;
    }

    public int getService_id() {
        return service_id;
    }

    public void setService_id(int service_id) {
        this.service_id = service_id;
    }

    public String getRectify_situation() {
        return rectify_situation;
    }

    public void setRectify_situation(String rectify_situation) {
        this.rectify_situation = rectify_situation;
    }

    public int getSeller_id() {
        return seller_id;
    }

    public void setSeller_id(int seller_id) {
        this.seller_id = seller_id;
    }
}
