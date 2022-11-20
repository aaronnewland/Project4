package com.example.project4.controllers;

import com.example.project4.Order;
import com.example.project4.Pizza;
import com.example.project4.StoreOrder;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class StoreOrdersViewController implements Initializable {
    private static StoreOrder storeOrder;
    private Order displayedOrder;

    @FXML
    private ComboBox<Integer> orderNumbersComboBox;
    @FXML
    private TextField orderTotal;
    @FXML
    private ListView<Pizza> displayedOrderList;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        displayedOrder = noStoreOrders() ? null : storeOrder.getOrders().get(0);
        updateStoreOrdersList();
        updateOrderNumbers();
        updateOrderTotal();
    }

    @FXML
    protected void handleOrderNumberChange() {
        Integer currentOrderNumber = orderNumbersComboBox.getSelectionModel().getSelectedItem();
        if (currentOrderNumber == null) return;
        storeOrder.getOrders().forEach(order -> {
            if (order.getOrderNumber() == currentOrderNumber) displayedOrder = order;
        });
        displayedOrderList.getItems().clear();
        displayedOrderList.getItems().addAll(displayedOrder.getOrder());
        updateOrderTotal();
    }

    @FXML
    protected void handleCancelOrder() {
        int displayedOrderIndex = storeOrder.getOrders().indexOf(displayedOrder);
        if (displayedOrderIndex == storeOrder.getOrders().size() - 1) displayedOrderIndex -= 1;
        storeOrder.getOrders().remove(displayedOrder);
        if (storeOrder.getOrders().isEmpty()) {
            clearFields();
            return;
        }
        if (storeOrder.getOrders().get(displayedOrderIndex).getOrder().isEmpty())
            displayedOrder = storeOrder.getOrders().get(displayedOrderIndex);
        updateStoreOrdersList();
        updateOrderNumbers();
    }

    @FXML
    protected void handleExportStoreOrders() {

    }

    public void addOrder(Order order) {
        if (noStoreOrders()) storeOrder = new StoreOrder();
        storeOrder.add(order);
        displayedOrder = storeOrder.getOrders().get(0);
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
        storeOrder.getOrderNumbers().clear();
        orderNumbersComboBox.getItems().clear();
        storeOrder.getOrders().forEach(order -> storeOrder.getOrderNumbers().add(order.getOrderNumber()));
        orderNumbersComboBox.getItems().addAll(storeOrder.getOrderNumbers());
        if (orderNumbersComboBox.getItems().size() != 0)
            orderNumbersComboBox.getSelectionModel().select(orderNumbersComboBox.getItems().get(0));
    }

    private void updateOrderTotal() {
        if (displayedOrder != null) orderTotal.setText(String.format("%.2f", displayedOrder.getOrderTotal()));
    }

    private boolean noStoreOrders() {
        return storeOrder == null || storeOrder.getOrders().isEmpty();
    }

    private void clearFields() {
        orderNumbersComboBox.getItems().clear();
        displayedOrderList.getItems().clear();
        orderTotal.clear();
    }
}
