package com.example.project4;

import com.example.project4.interfaces.Customizable;

import java.util.ArrayList;

public class StoreOrder implements Customizable {
    private ArrayList<Order> orders;

    public StoreOrder() {
        this.orders = new ArrayList<>();
    }

    @Override
    public boolean add(Object obj) {
        if (!(obj instanceof Order)) return false;
        return orders.add((Order) obj);
    }

    @Override
    public boolean remove(Object obj) {
        if (!(obj instanceof Order)) return false;
        return orders.remove((Order) obj);
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }

    public ArrayList<Integer> getOrderNumbers() {
        ArrayList<Integer> orderNumbers = new ArrayList<>();
        if (!orders.isEmpty()) orders.forEach(order -> orderNumbers.add(order.getOrderNumber()));
        return orderNumbers;
    }

    public Order getOrderById(int orderNumber) {
        Order res = null;
        for (Order o : orders) if (o.getOrderNumber() == orderNumber) res = o;
        return res;
    }

    public void export() {

    }
}
