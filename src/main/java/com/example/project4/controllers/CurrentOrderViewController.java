package com.example.project4.controllers;

import com.example.project4.Order;
import com.example.project4.Pizza;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CurrentOrderViewController implements Initializable {
    private static StoreOrdersViewController storeOrdersViewController;
    private static int orderNumber;
    private static ArrayList<Pizza> currentOrder;
    private double subtotal;
    private double salesTax;
    private final double njSalesTaxPercentage = 0.06625;
    private double orderTotal;

    @FXML
    private TextField orderNumberTextField, subtotalTextField, salesTaxTextField, orderTotalTextField;
    @FXML
    private ListView<Pizza> currentOrderList;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        subtotal = 0;
        salesTax = 0;
        orderTotal = 0;
        displayOrderNumber();
        updateCurrentOrderList();
    }

    @FXML
    protected void handleRemovePizza() {
        Pizza pizzaToRemove = currentOrderList.getSelectionModel().getSelectedItem();
        removeFromCurrentOrder(pizzaToRemove);
        updateCurrentOrderList();
    }

    @FXML
    protected void handlePlaceOrder() {
        Order order = new Order(orderNumber, currentOrder, orderTotal);
        storeOrdersViewController.addOrder(order);
        System.out.println("ORDER PLACE " +   order.getOrder());
        orderNumber++;
        handleClearOrder();
    }

    @FXML
    protected void handleClearOrder() {
        currentOrder = null;
        orderNumberTextField.setText("");
        updateCurrentOrderList();
    }

    public void setStoreOrdersViewController(StoreOrdersViewController storeOrdersViewController) {
        this.storeOrdersViewController = storeOrdersViewController;
    }

    public void addToCurrentOrder(Pizza pizza) {
        if (currentOrder == null) currentOrder = new ArrayList<>();
        currentOrder.add(pizza);
        orderNumberTextField.setText(String.valueOf(orderNumber));
        updateCurrentOrderList();
    }

    public void removeFromCurrentOrder(Pizza pizza) {
        if (pizza == null || !currentOrder.contains(pizza)) return;
        currentOrder.remove(pizza);
        updateCurrentOrderList();
    }

    private void updateCurrentOrderList() {
        clearCurrentOrderList();
        getCalculatedPrices();
        if (currentOrder != null) currentOrderList.getItems().addAll(currentOrder);
    }

    private void clearCurrentOrderList() {
        if (currentOrderList.getItems() != null) currentOrderList.getItems().clear();
    }

    private void getCalculatedPrices() {
        subtotal = 0;
        if (currentOrder != null) for (Pizza x : currentOrder) subtotal += x.price();
        salesTax = njSalesTaxPercentage * subtotal;
        orderTotal = subtotal + salesTax;
        subtotalTextField.setText(String.format("%.2f", subtotal));
        salesTaxTextField.setText(String.format("%.2f", salesTax));
        orderTotalTextField.setText(String.format("%.2f", orderTotal));
    }

    private void displayOrderNumber() {
        if (orderNumber == 0) orderNumber = 1;
        if (currentOrder != null) orderNumberTextField.setText(String.valueOf(orderNumber));
    }
}
