package com.example.project4;

import java.util.ArrayList;

public class Order {
    private int orderNumber;
    private ArrayList<Pizza> order;
    private double orderTotal;

    public Order(int orderNumber, ArrayList<Pizza> order, double orderTotal) {
        this.orderNumber = orderNumber;
        this.order = order;
        this.orderTotal = orderTotal;
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

    public double getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(double orderTotal) {
        this.orderTotal = orderTotal;
    }
}
