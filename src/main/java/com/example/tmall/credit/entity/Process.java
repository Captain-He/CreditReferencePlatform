package com.example.tmall.credit.entity;

public class Process {
    private int process_id;
    private int service_id;
    private String certain_time;
    private String dispatch_time;
    private String execute_time;
    private String service_exception;
    private int seller_id;
    private int user_id;

    public Process() {
    }

    public int getProcess_id() {
        return process_id;
    }

    public void setProcess_id(int process_id) {
        this.process_id = process_id;
    }

    public int getService_id() {
        return service_id;
    }

    public void setService_id(int service_id) {
        this.service_id = service_id;
    }

    public String getCertain_time() {
        return certain_time;
    }

    public void setCertain_time(String certain_time) {
        this.certain_time = certain_time;
    }

    public String getDispatch_time() {
        return dispatch_time;
    }

    public void setDispatch_time(String dispatch_time) {
        this.dispatch_time = dispatch_time;
    }

    public String getExecute_time() {
        return execute_time;
    }

    public void setExecute_time(String execute_time) {
        this.execute_time = execute_time;
    }

    public String getService_exception() {
        return service_exception;
    }

    public void setService_exception(String service_exception) {
        this.service_exception = service_exception;
    }

    public int getSeller_id() {
        return seller_id;
    }

    public void setSeller_id(int seller_id) {
        this.seller_id = seller_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
