package com.example.project4;

import com.example.project4.interfaces.Customizable;

import java.util.ArrayList;

public class Order implements Customizable {
    private static int _orderNumber;
    private int orderNumber;
    private ArrayList<Pizza> order;
    private final double njSalesTaxPercentage = 0.06625;

    public Order() {
        _orderNumber += 1;
        this.orderNumber = _orderNumber;
        this.order = new ArrayList<>();
    }

    public Order(ArrayList<Pizza> order) {
        this();
        this.order = order;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public ArrayList<Pizza> getOrder() {
        return order;
    }

    public double getSubtotal() {
        int subtotal = 0;
        if (!order.isEmpty()) for (Pizza p : order) subtotal += p.price();
        return subtotal;
    }

    public double getSalesTax() {
        return njSalesTaxPercentage * getSubtotal();
    }

    public double getOrderTotal() {
        return getSubtotal() + getSalesTax();
    }

    @Override
    public boolean add(Object obj) {
        if (!(obj instanceof Pizza)) return false;
        return order.add((Pizza) obj);
    }

    @Override
    public boolean remove(Object obj) {
        if (!(obj instanceof Pizza)) return false;
        return order.remove((Pizza) obj);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        order.forEach((pizza) -> sb.append(pizza + "\n"));
        int last = sb.lastIndexOf("\n");
        if (last >= 0) { sb.delete(last, sb.length()); }
        return sb.toString();
    }
}
