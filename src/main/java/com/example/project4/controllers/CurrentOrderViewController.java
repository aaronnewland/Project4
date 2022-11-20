package com.example.project4.controllers;

import com.example.project4.Pizza;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CurrentOrderViewController implements Initializable {
    private StoreOrdersViewController storeOrdersViewController;
    private static int orderNumber = 1;
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

    }

    @FXML
    protected void handlePlaceOrder() {

    }

    @FXML
    protected void handleClearOrder() {
        currentOrder.clear();
        currentOrderList.getItems().clear();
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
        if (currentOrder.contains(pizza)) {
            currentOrder.remove(pizza);
            updateCurrentOrderList();
        }
    }

    private void updateCurrentOrderList() {
        if (currentOrder != null) {
            currentOrderList.getItems().addAll(currentOrder);
            getCalculatedPrices();
        }
    }

    private void getCalculatedPrices() {
        subtotal = 0;
        for (Pizza x : currentOrder) subtotal += x.price();
        salesTax = njSalesTaxPercentage * subtotal;
        orderTotal = subtotal + salesTax;
        subtotalTextField.setText(String.format("%.2f", subtotal));
        salesTaxTextField.setText(String.format("%.2f", salesTax));
        orderTotalTextField.setText(String.format("%.2f", orderTotal));
    }

    private void displayOrderNumber() {
        if (currentOrder != null) orderNumberTextField.setText(String.valueOf(orderNumber));
    }
}
