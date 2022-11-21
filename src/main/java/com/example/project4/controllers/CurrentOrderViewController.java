package com.example.project4.controllers;

import com.example.project4.Order;
import com.example.project4.Pizza;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class CurrentOrderViewController implements Initializable {
    private static StoreOrdersViewController storeOrdersViewController;
    private static Order currentOrder;

    @FXML
    private TextField orderNumberTextField, subtotalTextField, salesTaxTextField, orderTotalTextField;
    @FXML
    private ListView<Pizza> currentOrderList;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (currentOrder == null) currentOrder = new Order();
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
        if (currentOrder.getOrder().isEmpty()) return;
        storeOrdersViewController.addOrder(currentOrder);
        handleClearOrder();
    }

    @FXML
    protected void handleClearOrder() {
        currentOrder = new Order();
        orderNumberTextField.setText("");
        updateCurrentOrderList();
    }

    public void setStoreOrdersViewController(StoreOrdersViewController storeOrdersViewController) {
        this.storeOrdersViewController = storeOrdersViewController;
    }

    public void addToCurrentOrder(Pizza pizza) {
        if (currentOrder == null) currentOrder = new Order();
        currentOrder.add(pizza);
        orderNumberTextField.setText(String.valueOf(currentOrder.getOrderNumber()));
        updateCurrentOrderList();
    }

    public void removeFromCurrentOrder(Pizza pizza) {
        if (pizza == null) return;
        currentOrder.remove(pizza);
        updateCurrentOrderList();
    }

    private void updateCurrentOrderList() {
        clearCurrentOrderList();
        if (currentOrder == null)  {
            clearPrices();
            return;
        }
        getCalculatedPrices();
        currentOrderList.getItems().addAll(currentOrder.getOrder());
    }

    private void clearCurrentOrderList() {
        if (currentOrderList.getItems() != null) currentOrderList.getItems().clear();
    }

    private void getCalculatedPrices() {
        subtotalTextField.setText(String.format("%.2f", currentOrder.getSubtotal()));
        salesTaxTextField.setText(String.format("%.2f", currentOrder.getSalesTax()));
        orderTotalTextField.setText(String.format("%.2f", currentOrder.getOrderTotal()));
    }

    private void clearPrices() {
        subtotalTextField.setText(String.format("%.2f", 0.00));
        salesTaxTextField.setText(String.format("%.2f", 0.00));
        orderTotalTextField.setText(String.format("%.2f", 0.00));
    }

    private void displayOrderNumber() {
        if (currentOrder != null) orderNumberTextField.setText(String.valueOf(currentOrder.getOrderNumber()));
    }
}
