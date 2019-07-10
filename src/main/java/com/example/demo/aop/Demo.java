package com.example.demo.aop;

/**
 * @Author: ChangYu
 * @Date: 5/22/2019 3:34 PM
 * @Version 1.0
 */
public enum Demo {
    WXPAY("微信支付",20),ALIPAY("支付宝支付",10);

    private String name;
    private int index;

    Demo(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }}





