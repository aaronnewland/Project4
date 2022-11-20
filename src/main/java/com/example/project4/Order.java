package com.example.project4;

import java.util.ArrayList;

public class Order {
    private int orderNumber;
    private ArrayList<Pizza> order;

    public Order(int orderNumber, ArrayList<Pizza> order) {
        this.orderNumber = orderNumber;
        this.order = order;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public ArrayList<Pizza> getOrder() {
        return order;
    }

    public void setOrder(ArrayList<Pizza> order) {
        this.order = order;
    }
}
