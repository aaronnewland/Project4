package com.example.project4.controllers;

import com.example.project4.Order;
import com.example.project4.Pizza;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class StoreOrdersViewController implements Initializable {
    private static ArrayList<Order> storeOrders;
    private ArrayList<Integer> orderNumbers;
    private Order displayedOrder;

    @FXML
    private ComboBox<Integer> orderNumbersComboBox;
    @FXML
    private TextField orderTotal;
    @FXML
    private ListView<Pizza> displayedOrderList;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        updateStoreOrdersList();
        updateOrderNumbers();
        displayedOrder = storeOrders == null ? null : storeOrders.get(0);
        updateOrderTotal();
    }

    @FXML
    protected void handleOrderNumberChange() {
        int currentOrderNumber = orderNumbersComboBox.getSelectionModel().getSelectedItem();
        storeOrders.forEach(order -> {
            if (order.getOrderNumber() == currentOrderNumber) displayedOrder = order;
        });
        displayedOrderList.getItems().clear();
        displayedOrderList.getItems().addAll(displayedOrder.getOrder());
        updateOrderTotal();
    }

    @FXML
    protected void handleCancelOrder() {

    }

    @FXML
    protected void handleExportStoreOrders() {

    }

    public void addOrder(Order order) {
        if (noStoreOrders()) storeOrders = new ArrayList<>();
        storeOrders.add(order);
        updateStoreOrdersList();
        updateOrderNumbers();
        System.out.println("Store orders after add order: ");
        storeOrders.forEach(x -> System.out.println(x.getOrder() + "\n"));
    }

    private void updateStoreOrdersList() {
        if (noStoreOrders()) return;
        displayedOrder = storeOrders.get(0);
        displayedOrderList.getItems().clear();
        displayedOrderList.getItems().addAll(displayedOrder.getOrder());
    }

    private void updateOrderNumbers() {
        if (noStoreOrders()) return;
        if (noOrderNumbers()) orderNumbers = new ArrayList<>();
        orderNumbers.clear();
        orderNumbersComboBox.getItems().clear();
        storeOrders.forEach(order -> orderNumbers.add(order.getOrderNumber()));
        orderNumbersComboBox.getItems().addAll(orderNumbers);
        if (orderNumbersComboBox.getItems().size() != 0)
            orderNumbersComboBox.getSelectionModel().select(orderNumbersComboBox.getItems().get(0));
    }

    private void updateOrderTotal() {
        if (displayedOrder != null) orderTotal.setText(String.format("%.2f", displayedOrder.getOrderTotal()));
    }

    private boolean noStoreOrders() {
        return storeOrders == null;
    }

    private boolean noOrderNumbers() {
        return orderNumbers == null;
    }
}
