package com.example.project4.controllers;

import com.example.project4.Order;
import com.example.project4.Pizza;
import com.example.project4.StoreOrder;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Controller for StoreOrdersView-view.fxml
 * @author Aaron Newland, Dylan Pina
 */
public class StoreOrdersViewController implements Initializable {
    private static StoreOrder storeOrder;
    private Order displayedOrder;

    @FXML
    private ComboBox<Integer> orderNumbersComboBox;
    @FXML
    private TextField orderTotal;
    @FXML
    private ListView<Pizza> displayedOrderList;

    /**
     * Used when view is opened. Sets initial values and fields required for view operation.
     * @param location used to resolve relative paths for the root object, or null if the location is not known.
     * @param resource used to localize the root object, or null if the root object was not localized.
     */
    @Override
    public void initialize(URL location, ResourceBundle resource) {
        displayedOrder = noStoreOrders() ? null : storeOrder.getOrders().get(0);
        updateStoreOrdersList();
        updateOrderNumbers();
        updateOrderTotal();
    }

    /**
     * Action handler for combo box for selecting order numbers, then changing the displayed order.
     */
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

    /**
     * Action handler for cancel order button.
     * Allows user to cancel order.
     */
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

    /**
     * Action handler for export store orders button.
     * Allows user to export store orders to a text file.
     * @throws IOException
     */
    @FXML
    protected void handleExportStoreOrders() throws IOException {
        storeOrder.export();
    }

    /**
     * Adds current order to store orders.
     * @param order order to be added to store orders.
     */
    public void addOrder(Order order) {
        if (noStoreOrders()) storeOrder = new StoreOrder();
        storeOrder.add(order);
        displayedOrder = storeOrder.getOrders().get(0);
        updateStoreOrdersList();
        updateOrderNumbers();
    }

    /**
     * Updates list view of order being displayed when different order is selected.
     */
    private void updateStoreOrdersList() {
        if (noStoreOrders()) return;
        displayedOrderList.getItems().clear();
        displayedOrderList.getItems().addAll(displayedOrder.getOrder());
    }

    /**
     * Updates order numbers if modifications are made.
     */
    private void updateOrderNumbers() {
        if (noStoreOrders()) return;
        storeOrder.getOrderNumbers().clear();
        orderNumbersComboBox.getItems().clear();
        storeOrder.getOrders().forEach(order -> storeOrder.getOrderNumbers().add(order.getOrderNumber()));
        orderNumbersComboBox.getItems().addAll(storeOrder.getOrderNumbers());
        if (orderNumbersComboBox.getItems().size() != 0)
            orderNumbersComboBox.getSelectionModel().select(orderNumbersComboBox.getItems().get(0));
    }

    /**
     * Updates order total field when modifications are made. Set to 2 decimal places.
     */
    private void updateOrderTotal() {
        if (displayedOrder != null) orderTotal.setText(String.format("%.2f", displayedOrder.getOrderTotal()));
    }

    /**
     * Checks if there are no store orders to display.
     * @return true if at least 1 store order is in use, false otherwise.
     */
    private boolean noStoreOrders() {
        return storeOrder == null || storeOrder.getOrders().isEmpty();
    }

    /**
     * Clears all fields in store order view.
     */
    private void clearFields() {
        orderNumbersComboBox.getItems().clear();
        displayedOrderList.getItems().clear();
        orderTotal.clear();
    }
}
