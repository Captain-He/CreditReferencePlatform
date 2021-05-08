package com.example.tmall.credit.entity;


public class ProductInfo {
    //产品信息
    private int service_id;
    private String service_name;
    private String service_intro;
    private String service_people;
    private String service_device;
    private String service_phone;
    private String service_duration;
    private Double service_price;
    private String service_post;
    private String service_complaint;
    private String service_confirmtime;
    private String service_dispatchtime;
    private String service_procedure;
    private String service_legalinfo;
    private String service_audience;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    private String service_personalize;
    private int seller_id;
    private String username;

    public int getService_id() {
        return service_id;
    }

    public void setService_id(int service_id) {
        this.service_id = service_id;
    }

    public String getService_name() {
        return service_name;
    }

    public void setService_name(String service_name) {
        this.service_name = service_name;
    }

    public String getService_intro() {
        return service_intro;
    }

    public void setService_intro(String service_intro) {
        this.service_intro = service_intro;
    }

    public String getService_people() {
        return service_people;
    }

    public void setService_people(String service_people) {
        this.service_people = service_people;
    }

    public String getService_device() {
        return service_device;
    }

    public void setService_device(String service_device) {
        this.service_device = service_device;
    }

    public String getService_phone() {
        return service_phone;
    }

    public void setService_phone(String service_phone) {
        this.service_phone = service_phone;
    }

    public String getService_duration() {
        return service_duration;
    }

    public void setService_duration(String service_duration) {
        this.service_duration = service_duration;
    }

    public Double getService_price() {
        return service_price;
    }

    public void setService_price(Double service_price) {
        this.service_price = service_price;
    }

    public String getService_post() {
        return service_post;
    }

    public void setService_post(String service_post) {
        this.service_post = service_post;
    }

    public String getService_complaint() {
        return service_complaint;
    }

    public void setService_complaint(String service_complaint) {
        this.service_complaint = service_complaint;
    }

    public String getService_confirmtime() {
        return service_confirmtime;
    }

    public void setService_confirmtime(String service_confirmtime) {
        this.service_confirmtime = service_confirmtime;
    }

    public String getService_dispatchtime() {
        return service_dispatchtime;
    }

    public void setService_dispatchtime(String service_dispatchtime) {
        this.service_dispatchtime = service_dispatchtime;
    }

    public String getService_procedure() {
        return service_procedure;
    }

    public void setService_procedure(String service_procedure) {
        this.service_procedure = service_procedure;
    }

    public String getService_legalinfo() {
        return service_legalinfo;
    }

    public void setService_legalinfo(String service_legalinfo) {
        this.service_legalinfo = service_legalinfo;
    }

    public String getService_audience() {
        return service_audience;
    }

    public void setService_audience(String service_audience) {
        this.service_audience = service_audience;
    }

    public String getService_personalize() {
        return service_personalize;
    }

    public void setService_personalize(String service_personalize) {
        this.service_personalize = service_personalize;
    }

    public int getSeller_id() {
        return seller_id;
    }

    public void setSeller_id(int seller_id) {
        this.seller_id = seller_id;
    }

    public ProductInfo(int service_id, String service_name, String service_intro, String service_people, String service_device, String service_phone, String service_duration, Double service_price, String service_post, String service_complaint, String service_confirmtime, String service_dispatchtime, String service_procedure, String service_legalinfo, String service_audience, String service_personalize, int seller_id, String username) {
        this.service_id = service_id;
        this.service_name = service_name;
        this.service_intro = service_intro;
        this.service_people = service_people;
        this.service_device = service_device;
        this.service_phone = service_phone;
        this.service_duration = service_duration;
        this.service_price = service_price;
        this.service_post = service_post;
        this.service_complaint = service_complaint;
        this.service_confirmtime = service_confirmtime;
        this.service_dispatchtime = service_dispatchtime;
        this.service_procedure = service_procedure;
        this.service_legalinfo = service_legalinfo;
        this.service_audience = service_audience;
        this.service_personalize = service_personalize;
        this.seller_id = seller_id;
        this.username = username;
    }
}
