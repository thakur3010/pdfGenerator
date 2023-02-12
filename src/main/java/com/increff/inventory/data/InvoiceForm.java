package com.increff.inventory.data;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class InvoiceForm {


    private Integer id;
    private Integer orderId;
    private LocalDateTime date;


    private LocalDateTime last_updated;

    private Integer total_items;
    private Double total_cost;

    private List<InvoiceItemForm> orderItems;

    public List<InvoiceItemForm> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<InvoiceItemForm> orderItems) {
        this.orderItems = orderItems;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Integer getTotal_items() {
        return total_items;
    }

    public void setTotal_items(Integer total_items) {
        this.total_items = total_items;
    }

    public Double getTotal_cost() {
        return total_cost;
    }

    public void setTotal_cost(Double total_cost) {
        this.total_cost = total_cost;
    }
    public LocalDateTime getLast_updated() {
        return last_updated;
    }

    public void setLast_updated(LocalDateTime last_updated) {
        this.last_updated = last_updated;
    }
}
