package com.example.demo.domain_cluster;

import java.io.Serializable;

/**
 * @author 
 */
public class GoodsSnapshot implements Serializable {
    /**
     * 订单号
     */
    private Integer orderId;

    /**
     * 商品名
     */
    private String name;

    /**
     * 价格
     */
    private Integer price;

    private static final long serialVersionUID = 1L;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}