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
        displayedOrder = noStoreOrders() ? null : storeOrders.get(0);
        updateStoreOrdersList();
        updateOrderNumbers();
        updateOrderTotal();
    }

    @FXML
    protected void handleOrderNumberChange() {
        Integer currentOrderNumber = orderNumbersComboBox.getSelectionModel().getSelectedItem();
        if (currentOrderNumber == null) return;
        storeOrders.forEach(order -> {
            if (order.getOrderNumber() == currentOrderNumber) displayedOrder = order;
        });
        displayedOrderList.getItems().clear();
        displayedOrderList.getItems().addAll(displayedOrder.getOrder());
        updateOrderTotal();
    }

    @FXML
    protected void handleCancelOrder() {
        int displayedOrderIndex = storeOrders.indexOf(displayedOrder);
        if (displayedOrderIndex == storeOrders.size() - 1) displayedOrderIndex -= 1;
        storeOrders.remove(displayedOrder);
        if (storeOrders.isEmpty()) {
            clearFields();
            return;
        }
        if (storeOrders.get(displayedOrderIndex).getOrder().isEmpty())
            displayedOrder = storeOrders.get(displayedOrderIndex);
        updateStoreOrdersList();
        updateOrderNumbers();
    }

    @FXML
    protected void handleExportStoreOrders() {

    }

    public void addOrder(Order order) {
        if (noStoreOrders()) storeOrders = new ArrayList<>();
        storeOrders.add(order);
        displayedOrder = storeOrders.get(0);
        updateStoreOrdersList();
        updateOrderNumbers();
    }

    private void updateStoreOrdersList() {
        if (noStoreOrders()) return;
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
        return storeOrders == null || storeOrders.isEmpty();
    }

    private boolean noOrderNumbers() {
        return orderNumbers == null || orderNumbers.isEmpty();
    }

    private void clearFields() {
        orderNumbers.clear();
        orderNumbersComboBox.getItems().clear();
        displayedOrderList.getItems().clear();
        orderTotal.clear();
    }
}
